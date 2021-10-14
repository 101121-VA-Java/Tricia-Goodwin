package com.revature.models;

//access modifier -- class -- class name
public class Kitty{
    public String furColor;
    public String name;
    public boolean isKitten;
    public boolean isOutdoor;
    

    public Kitty(){
    } //No args contructor

    public Kitty(String name){
        this.name = name;
    } //single arg constuctor

    public Kitty(String name, boolean isKitten){
        this.name = name;
        this.isKitten = isKitten;
    } //multi arg constuctor

    public String hunting(){
        if(this.isOutdoor == true){
            return "I'm hunting chipmunks";
        } else{
            return "I'm chasing laser pointers";
        }
    }

    public void sleep(){
        System.out.println("Zzzzzzzzzz");
    }

}