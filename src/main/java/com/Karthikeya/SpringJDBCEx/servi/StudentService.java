package com.Karthikeya.SpringJDBCEx.servi;

import com.Karthikeya.SpringJDBCEx.model.Student;
import com.Karthikeya.SpringJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s); // spring tells that hey repo this is you resposiblity to save the method
    }


    public List<Student> getStudent() {

       return repo.findAll();
    }
}
