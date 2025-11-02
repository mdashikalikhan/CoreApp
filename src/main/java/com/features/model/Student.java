package com.features.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;

    private int gradeLevel;

    private double gpa;

    private String gender;

    private List<String> favourites;

}
