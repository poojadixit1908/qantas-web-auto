package com.qantas.automation.pageobjects;

public class Car {

    private String name;
    private String color;
    private int makeYear;

    public Car(String name, String color, int makeYear) {
        this.name = name;
        this.color = color;
        this.makeYear = makeYear;
    }

    public void printCarDetails() {
        System.out.println("The car name is: " + this.name);
        System.out.println("The car color is: " + this.color);
        System.out.println("The car makeYear is: " + this.makeYear);
    }
}
