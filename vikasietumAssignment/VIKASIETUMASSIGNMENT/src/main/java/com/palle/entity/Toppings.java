package com.palle.entity;

public enum Toppings {



    BlackOlive(20, PizzaType.VEG),
    Capsicum(25, PizzaType.VEG),
    Paneer(35, PizzaType.VEG),
    Mushroom(30, PizzaType.VEG),
    FreshTomato(10, PizzaType.VEG),
    ChickenTikka_T(35, PizzaType.NON_VEG),
    BarbequeChicken(45, PizzaType.NON_VEG),
    GrilledChicken(40, PizzaType.NON_VEG);

    Toppings(double value,PizzaType pizzaType) {
        this.value = value;
        this.pizzaType = pizzaType;
    }

    final double value;
    final PizzaType pizzaType;

    public Double getValue() {
        return value;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }
}
