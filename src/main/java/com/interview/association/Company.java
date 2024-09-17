package com.interview.association;

import java.util.ArrayList;
import java.util.List;
public class Company {
    private String companyName;
    private List<Section> sections;

    private Section pSection;

    public Company(String companyName){
        this.companyName = companyName;
        sections = new ArrayList<>();
    }

    public void addSection(Section section)
    {
        sections.add(section);
    }

    public List<Section> getSections()
    {
        return new ArrayList<>(sections);
    }

    public int getTotalSections()
    {
        return sections.size();
    }
}
