package cl.crisgvera.ensayotres.controller;

import cl.crisgvera.ensayotres.model.Course;
import cl.crisgvera.ensayotres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "index";
    }

    @GetMapping("/course/{id}")
    public String getAllStudentsByCourseId(@PathVariable String id, Model model) {
        Course course = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/rest/course/" + id)
                .retrieve()
                .bodyToMono(Course.class)
                .block();

        model.addAttribute("course", course);
        return "forward:/";
    }

    @GetMapping("/course")
    public String getAllStudents(@RequestParam("course-id") Long id) {
        return "redirect:/course/" + id;
    }

    @GetMapping("/courses")
    public String getAll(Model model) {
        model.addAttribute("showCourses", true);
        return "forward:/";
    }

}
