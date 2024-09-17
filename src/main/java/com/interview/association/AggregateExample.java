package com.interview.association;

import java.util.ArrayList;
import java.util.List;

public class AggregateExample {

    public static void main(String[] args) {
        Student s1 = new Student("Pavel", 1);
        Student s2 = new Student("Shajid", 2);
        Student s3 = new Student("Polash", 3);
        Student s4 = new Student("Rubel", 4);

        List<Student> cse_students = new ArrayList<Student>();
        cse_students.add(s1);
        cse_students.add(s2);

        List<Student> ee_students = new ArrayList<Student>();
        ee_students.add(s3);
        ee_students.add(s4);

        Department CSE = new Department("CSE", cse_students);
        cse_students.add(new Student("SAMSU", 5));
        Department EE = new Department("EE", ee_students);

        List<Department> departments = new ArrayList<Department>();
        departments.add(CSE);
        departments.add(EE);

        Institute institute = new Institute("BITS", departments);


        System.out.println(institute.getTotalStudentsInInstitute());

        //departments = null;

        //System.out.println(institute.getTotalStudentsInInstitute());

        institute = null;

        System.out.println(departments);

        departments = null;

        System.out.println(cse_students);

    }
}
