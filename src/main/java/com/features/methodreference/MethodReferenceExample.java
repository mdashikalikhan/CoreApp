package com.features.methodreference;

import com.features.model.Student;
import com.features.model.StudentDataBase;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceExample {


    static Predicate<Student> p1 = MethodReferenceExample::greaterThanGradeLvel;

    public static boolean greaterThanGradeLvel(Student s){
        return s.getGradeLevel()>3;
    }
    public static void main(String[] args) {
        //p1.test(StudentDataBase.studentSupplier.get());
        System.out.println(p1.test(StudentDataBase.studentSupplier.get()));

        Supplier<Student> studentSupplier = Student::new;

        System.out.println(studentSupplier.get());
    }
}
