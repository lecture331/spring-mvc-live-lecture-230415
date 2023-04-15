package com.example.springmvclivelecture230415;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "courseServletBody", urlPatterns = "/course/body")
public class CourseServletBody extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // printHttpInfo(req);

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
        course.setCost(9999999);

        // 요청에 대한 결과 반환
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        res.setStatus(HttpStatus.CREATED.value());

       // Object To JSON
        res.getWriter().write(new ObjectMapper().writeValueAsString(course));
    }

    private void printHttpInfo(HttpServletRequest req) {
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        System.out.println("req.getServerPort() = " + req.getServerPort());
        System.out.println("req.getServletPath() = " + req.getServletPath());
        System.out.println("req.getMethod() = " + req.getMethod());
    }
}
