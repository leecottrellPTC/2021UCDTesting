package com.leecottrell.junitlecture1;

public class SimpleClass {
    private int weight;
    private String name;

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        //this.weight = weight*3;       //original failed test
        //refactored by Cottrell on 10-25-2021 to pass test
        this.weight = weight;   //my fix Cottrell
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SimpleClass() {
    }
    public SimpleClass(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    


    
}
