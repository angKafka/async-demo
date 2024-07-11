package org.rdutta.practice_rest.rest;

import jakarta.annotation.PostConstruct;
import org.rdutta.practice_rest.custome_exception.StudentNotFoundException;
import org.rdutta.practice_rest.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private List<Student> students = new ArrayList<>();



    // Good Use
    @PostConstruct
    public void init() {
        students.add(new Student("Raj", "Dutta"));
        students.add(new Student("Prerna", "Pallavi"));
    }

    @GetMapping("/findAll")
    public List<Student> listOfAllStudents() {
        return students;
    }

    @GetMapping("/{student_id}")
    public Student getStudentById(@PathVariable("student_id") int studentId) {

        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found "+studentId);
        }
        return students.get(studentId);
    }
}
