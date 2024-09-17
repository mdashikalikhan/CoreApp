package com.interview.association;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Section {

    private String name;

    public Section(String name) {
        this.name = name;
    }
}
