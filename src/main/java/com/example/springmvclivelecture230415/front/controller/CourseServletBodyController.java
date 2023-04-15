package com.example.springmvclivelecture230415.front.controller;

import com.example.springmvclivelecture230415.Course;
import com.example.springmvclivelecture230415.front.ControllerInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CourseServletBodyController implements ControllerInterface {
    @Override
    public Course service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // HTTP Body 정보 가져오기
        ServletInputStream inputStream = req.getInputStream(); // HTTP Body에서 가져온 데이터를 바이트코드로 변환
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 바이트코드를 String 으로 변환
        System.out.println("body = " + body);


        // JSON To Object
        Course course = new ObjectMapper().readValue(body, Course.class);
        System.out.println("course.getTitle() = " + course.getTitle());
        System.out.println("course.getInstructor() = " + course.getInstructor());
        System.out.println("course.getCost() = " + course.getCost());

        // 가격 수정
        course.setCost(1000);

        return course;
    }
}
