package com.example.interntask;

public class Item {
    private String name;
    private String age;
    private String roll;
    public Item(String name,String age,String roll){
        this.name=name;
        this.age=age;
        this.roll=roll;
    }
    public String getName(){
        return  name;
    }
    public String getAge(){
        return age;
    }
    public String getRoll(){
        return roll;
    }
}
