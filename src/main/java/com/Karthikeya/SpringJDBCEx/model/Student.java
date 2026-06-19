package com.Karthikeya.SpringJDBCEx.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // beacuse we are creating many student here so we will new beans every time

public class Student {
    private int RollNo;
    private String name;
    private int marks;

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    // id we want to generate a object we also need the tostring method

    @Override
    public String toString() {
        return "Student{" +
                "RollNo=" + RollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
