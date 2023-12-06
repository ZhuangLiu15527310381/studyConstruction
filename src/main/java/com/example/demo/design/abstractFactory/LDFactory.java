package com.example.demo.design.abstractFactory;

import com.example.demo.design.abstractFactory.model.LDCheesePizza;
import com.example.demo.design.abstractFactory.model.Pizza;

public class LDFactory implements AbsFactory{

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if ("papper".equals(orderType)){
            pizza = new LDCheesePizza();
        }
        return pizza;
    }
}
