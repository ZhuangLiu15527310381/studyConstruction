package com.example.demo.design.prototype.model;

import lombok.Getter;

public class Sheep implements Cloneable{

    private String name;
    @Getter
    private int age;
    @Getter
    private String color;

    @Getter
    private String address="蒙古羊";

    public Sheep friend;//是对象，克隆是会如何处理

    public Sheep(String name,int age,String color){
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
