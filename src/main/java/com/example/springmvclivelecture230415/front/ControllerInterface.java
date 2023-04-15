package com.example.springmvclivelecture230415.front;

import com.example.springmvclivelecture230415.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerInterface {
    Course service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
