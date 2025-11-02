package com.features.model;

import java.util.List;
import java.util.function.Supplier;

public class StudentDataBase {

    public static Supplier<Student> studentSupplier =

            () ->  new Student("s", 2, 9, "M",
                    List.of("F1", "F2", "F3", "F4", "F5"));;
    public static List<Student> getAllStudent(){
        Student std1 = new Student("std1", 3, 9, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        Student std2 = new Student("std2", 1, 5, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        Student std3 = new Student("std13", 2, 12, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        Student std4 = new Student("std4", 0, 100, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        Student std5 = new Student("std5", 5, 90, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        Student std6 = new Student("std6", 7, 8, "M",
                List.of("F1", "F2", "F3", "F4", "F5"));

        return List.of(std1, std2, std3, std4, std5, std6);
    }
}
