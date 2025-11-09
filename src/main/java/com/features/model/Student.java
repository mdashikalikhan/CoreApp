package com.features.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Student {

    @NonNull
    private String name;

    private int gradeLevel;

    private double gpa;

    private String gender;

    private List<String> favourites;


}
