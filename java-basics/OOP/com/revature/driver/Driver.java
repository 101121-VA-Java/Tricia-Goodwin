package com.revature.driver;

import com.revature.models.Kitty;

public class Driver{

    public static void main(String[] args){
        Kitty celeste = new Kitty("Celeste", false);
        celeste.isOutdoor = true;
        celeste.furColor = "Gray";

        Kitty tigerlily = new Kitty();
        tigerlily.isOutdoor = false;
        tigerlily.furColor = "Tabby";
        tigerlily.isKitten = true;
        tigerlily.name = "Tigerlily";


        System.out.println(celeste.name + ":");
        System.out.println(celeste.hunting());
        celeste.sleep();
        celeste.baby();

        System.out.println("\n"+ tigerlily.name + ":");
        System.out.println(tigerlily.hunting());
        tigerlily.sleep();
        tigerlily.baby();
    }
}