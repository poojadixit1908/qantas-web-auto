package com.qantas.automation.pageobjects;

public class TestingCars {

    public static void main(String[] args) {

        Car toyotaCamry = new Car("Camry", "blue", 2020);

        Car hondaCity = new Car("City", "Red", 2019);




        toyotaCamry.printCarDetails();
    }
}
