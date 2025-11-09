package com.features.constructorreference;

import com.features.model.Student;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefEx {

    static Supplier<Student> stdSupplier = Student::new;

    static Function<String, Student> stdFunction = Student::new;


    public static void main(String[] args) {
        System.out.println(stdSupplier.get());

        System.out.println(stdFunction.apply("Ashik"));
    }
}
