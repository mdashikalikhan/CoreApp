package com.interview.association;

public class CompositionExample {

    public static void main(String[] args) {
        Company techCompany = new Company("Tech Corp");

        techCompany.addSection(new Section("Engineering"));
        techCompany.addSection(new Section("Operations"));
        techCompany.addSection(new Section("Human Resources"));
        techCompany.addSection(new Section("Finance"));

        int d = techCompany.getTotalSections();
        System.out.println("Total Sections: " + d);

        System.out.println("Section names: ");
        for (Section sec : techCompany.getSections()) {
            System.out.println("- " + sec.getName());
        }


    }
}
