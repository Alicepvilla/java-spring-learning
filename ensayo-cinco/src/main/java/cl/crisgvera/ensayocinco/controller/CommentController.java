package cl.crisgvera.ensayocinco.controller;

import cl.crisgvera.ensayocinco.model.Comment;
import cl.crisgvera.ensayocinco.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private CommentService commentService;

    @GetMapping("/setup")
    public String setupComments(Model model) {
        List<Comment> comments = webClientBuilder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/comments")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Comment>>() {
                })
                .block();

        commentService.deleteAll();
        commentService.saveAll(comments);

        model.addAttribute("successfulMsg", "Datos correctamente cargados");
        return "forward:/";
    }

    @GetMapping("/post/{id}")
    public String getComments(@PathVariable String id, Model model) {
        try {
            model.addAttribute("postComments",
                    commentService.findAllByPostId_Id(Long.valueOf(id)));
            model.addAttribute("postId", id);
        } catch (Exception e) {
            model.addAttribute("errorMsg", "Invalid Post ID");
        }
        return "index";
    }

    @GetMapping("/post")
    public String getCommentsBuilder(@RequestParam("post-id") Long postId) {
        return "redirect:/comment/post/" + postId;
    }

}
