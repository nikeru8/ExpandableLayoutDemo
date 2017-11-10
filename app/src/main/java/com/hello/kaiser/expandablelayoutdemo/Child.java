package com.hello.kaiser.expandablelayoutdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser on 2017/11/10.
 */

public class Child {

    private List<String> fruitList = new ArrayList<>();

    private String fruit;

    public Child(String fruit) {
        this.fruit = fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }
}
