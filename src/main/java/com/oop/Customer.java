package com.oop;

public class Customer {

    private NewsPaperCompany newsPaperCompany;

    public void setNewsPaperCompany(NewsPaperCompany newsPaperCompany) {
        this.newsPaperCompany = newsPaperCompany;
    }

    public void cancelSubscription(){
        newsPaperCompany.stopPaperDelivery();
    }
}
