package cl.crisgvera.ensayocinco.controller;

import cl.crisgvera.ensayocinco.model.Post;
import cl.crisgvera.ensayocinco.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private PostService postService;

    @GetMapping("/setup")
    public String setupPosts() {
        List<Post> posts = webClientBuilder.build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Post>>() {})
                .block();

        postService.deleteAll();
        posts = postService.saveAll(posts);

        return "redirect:/comment/setup";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

}
