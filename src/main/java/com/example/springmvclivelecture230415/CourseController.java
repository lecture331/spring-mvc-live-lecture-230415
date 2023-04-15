package com.example.springmvclivelecture230415;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/controller/course")
public class CourseController {

    @PostMapping("/body")
    public ResponseEntity<?> courseBody(@RequestBody Course course) {
        System.out.println("course.toString() = " + course.toString());
        course.setCost(123456);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/query")
    public ResponseEntity<?> courseQuery(@PathParam("title") String title, @PathParam("instructor") String instructor, @PathParam("cost") double cost) {
        System.out.println("title = " + title);
        System.out.println("instructor = " + instructor);
        System.out.println("cost = " + cost);
        return ResponseEntity.ok(new Course(title, instructor, cost));
    }

    @GetMapping("/model-attribute")
    public ResponseEntity<?> courseModelAttribute (@ModelAttribute Course course) {
        System.out.println("course.toString() = " + course.toString());
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<?> course(Course course) {
        System.out.println("course.toString() = " + course.toString());
        return ResponseEntity.ok(course);
    }
}
