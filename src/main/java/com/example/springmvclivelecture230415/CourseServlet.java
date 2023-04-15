package com.example.springmvclivelecture230415;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "courseServlet", urlPatterns = "/course")
public class CourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //printHttpInfo(req);

        // 데이터 확인
        String title = req.getParameter("title");
        String instructor = req.getParameter("instructor");
        double cost = Double.parseDouble(req.getParameter("cost"));

        // 요청에 대한 결과 반환
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");


        // Object To JSON
        Course course = new Course(title, instructor, cost);
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
