package cl.crisgvera.ensayotres.rest;

import cl.crisgvera.ensayotres.model.Course;
import cl.crisgvera.ensayotres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/course")
public class CourseRest {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course getOne(@PathVariable String id) {
        try {
            return courseService.getOne(Long.valueOf(id));
        } catch (Exception e) {
            return null;
        }
    }
}
