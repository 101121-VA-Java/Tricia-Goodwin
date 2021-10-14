package com.revature.models;

//access modifier -- class -- class name
public class Human{
    public String hairColor;
    public int age;
    public String name;
    public boolean isRightHanded;

    public Human(){


    }

    public Human(String name){
        this.name = name;
    }

    public String eat(String food){
        return "I'm eating "+ food;
    }

    public void sleep(){
        System.out.println("Zzzzzzzzzz");
    }

}