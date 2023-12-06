package com.example.demo.design.abstractFactory.model;

public class LDPapperPizza  extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println("伦敦的胡椒pizza 准备原材料");
    }
}
