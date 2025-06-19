package com.oop.builder;

public class BuilderPatternTest {

    public static void main(String[] args) {
        User user =
               new User.Builder().age(43)
                       .name("MD. ASHIK ALI KHAN")
                       .build();
    }
}

class User {
    private String name;
    private int age;

    private User(Builder builder){
        name = builder.name;
        age = builder.age;
    }

    public static class Builder{
        private String name;
        private int age;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
