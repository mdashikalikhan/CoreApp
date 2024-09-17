package com.interview.association;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Department {

    private String deptName;
    private List<Student> students;

    public void addStudent(Student student)
    {
        students.add(student);
    }
}
