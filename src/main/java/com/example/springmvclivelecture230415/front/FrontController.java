package com.example.springmvclivelecture230415.front;

import com.example.springmvclivelecture230415.Course;
import com.example.springmvclivelecture230415.front.controller.CourseServletBodyController;
import com.example.springmvclivelecture230415.front.controller.CourseServletController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = "/front/*")
public class FrontController extends HttpServlet {

    private final Map<String, ControllerInterface> controllerStore = new HashMap<>();

    public FrontController() {
        controllerStore.put("/front/course", new CourseServletController());
        controllerStore.put("/front/course/body", new CourseServletBodyController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        printHttpInfo(req);

        // 요청을 구분해서 해당하는 Controller를 호출해서 사용
        ControllerInterface controller = controllerStore.get(req.getRequestURI());
        Course course = controller.service(req, res);


        // 요청에 대한 결과 반환
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        res.setStatus(HttpStatus.OK.value());


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
