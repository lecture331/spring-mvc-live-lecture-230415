package com.example.springmvclivelecture230415.front.controller;

import com.example.springmvclivelecture230415.Course;
import com.example.springmvclivelecture230415.front.ControllerInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseServletController implements ControllerInterface {
    @Override
    public Course service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String instructor = req.getParameter("instructor");
        double cost = Double.parseDouble(req.getParameter("cost"));

        return new Course(title, instructor, cost);
    }
}
