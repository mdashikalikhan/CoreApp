package com.interview.solid.dip;

public class EmailReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(String content) {
        System.out.println("Email Report Generator .." + content);
    }
}
