package com.features.methodreference;

import com.features.model.Student;
import com.features.model.StudentDataBase;

import java.util.function.Predicate;

public class MethodReferenceExample {


    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    /*public static boolean greaterThanGradeLvel(Student s){

    }*/
    public static void main(String[] args) {
        p1.test(StudentDataBase.studentSupplier.get());
    }
}
