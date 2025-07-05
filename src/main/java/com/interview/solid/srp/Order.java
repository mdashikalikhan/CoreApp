package com.interview.solid.srp;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int orderId;
    private String cutomerName;
    private String customerEmail;
    private List<String> orderItems;
}
