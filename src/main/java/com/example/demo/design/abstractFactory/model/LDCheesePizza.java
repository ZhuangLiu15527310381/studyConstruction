package com.example.demo.design.abstractFactory.model;

public class LDCheesePizza  extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦的奶酪pizza");
        System.out.println("伦敦的奶酪pizza 准备原材料");
    }
}
