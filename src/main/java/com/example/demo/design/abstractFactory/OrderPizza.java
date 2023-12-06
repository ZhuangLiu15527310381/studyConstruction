package com.example.demo.design.abstractFactory;

import com.example.demo.design.abstractFactory.model.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }


    private void setFactory(AbsFactory absFactory) {
        Pizza pizza = null;
        String orderType = "";//用户输入
        this.absFactory = absFactory;
        do {
            orderType = getType();
            //factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = absFactory.createPizza(orderType);
            if (Objects.nonNull(pizza)) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;
            }
        } while (true);

    }

    private String getType(){
        try{
            System.out.println("input pizza 种类:");
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            String str = strin.readLine();
            return str;
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }




}
