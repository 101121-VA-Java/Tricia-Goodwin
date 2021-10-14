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
        tigerlily.isKitten = false;
        tigerlily.name = "Tigerlily";


        System.out.println(celeste.hunting());
        celeste.sleep();

        System.out.println(tigerlily.hunting());
        tigerlily.sleep();

    }
}