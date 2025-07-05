package com.interview.solid.srp;

public class EmailService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("Email sent to " + to);
    }
}
