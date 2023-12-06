package com.example.demo.design.abstractFactory;

import com.example.demo.design.abstractFactory.model.BJCheesePizza;
import com.example.demo.design.abstractFactory.model.BJPepperPizza;
import com.example.demo.design.abstractFactory.model.Pizza;

public class BJFactory implements AbsFactory{


    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if ("papper".equals(orderType)){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
