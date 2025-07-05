package com.interview.solid.dip;

public class FileReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(String content) {
        System.out.println("File Report Generator...." + content);
    }
}
