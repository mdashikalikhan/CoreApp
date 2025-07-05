package com.interview.solid.srp;

import java.util.stream.Collectors;

public class OrderService {
    public final EmailService emailService ;

    public OrderService(EmailService emailService) {
        this.emailService = emailService;
    }
    public void processOrder(Order order) {
        System.out.println("Order Processed");
        emailService.sendEmail(order.getCustomerEmail(), order.getCutomerName(),
                order.getOrderItems().stream().collect(Collectors.joining(", ")));
    }
}
