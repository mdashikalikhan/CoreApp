package com.interview.solid.dip;

public class ReportService {

    private final ReportGenerator generator;

    public ReportService(ReportGenerator generator) {
        this.generator = generator;
    }

    public void createReport(String content) {
        generator.generateReport(content);
    }
}
