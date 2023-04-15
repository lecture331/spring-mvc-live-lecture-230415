package com.example.springmvclivelecture230415;

import lombok.*;

@Getter
@ToString
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String title;
    private String instructor;
    private double cost;

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Course(String title, String instructor, double cost) {
        this.title = title;
        this.instructor = instructor;
        this.cost = cost;
    }
}
