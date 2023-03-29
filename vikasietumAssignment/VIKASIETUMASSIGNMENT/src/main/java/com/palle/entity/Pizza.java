package com.palle.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.palle.datastructure.CollectionData.*;

public class Pizza {

    private PizzaType pizzaType;
    private PizzaName pizzaName;
    private Crust crust;
    private List<Toppings> toppings;
    private List<Sides> sidesList;
    private Size size;
    private boolean extraChees;

    public Pizza() {
    }

    private Pizza(Builder builder){
        this.crust = builder.crust;
        this.pizzaName = builder.pizzaName;
        this.pizzaType = builder.pizzaType;
        this.toppings = builder.toppings;
        this.size = builder.size;
        this.sidesList = builder.sidesList;
        this.extraChees = builder.extraChees;
    }


    public static class Builder{


        private PizzaType pizzaType;
        private PizzaName pizzaName;
        private Crust crust;
        private List<Toppings> toppings = new ArrayList<>();
        private List<Sides> sidesList = new ArrayList<>();
        private Size size;
        private boolean extraChees;


        public Builder(){

        }

        public Builder withPizzaType(String pizzaType){
            this.pizzaType = pizzaTypeMap.get(pizzaType);
            return this;
        }

        public Builder withPizzaName(String pizzaName){
            this.pizzaName = pizzaNameMap.get(pizzaName);
            return this;
        }

        public Builder withCrust(String crust){
            this.crust = crustMap.get(crust);
            return this;
        }

        public Builder withToppings(List<String> toppings){
            this.toppings =  toppings.stream()
                        .map(toppingMap::get)
                        .collect(Collectors.toList());
            return this;
        }

        public Builder withSize(String size){
            this.size = sizegMap.get(size);
            return this;

        }

        public Builder  withSides(List<String> sides){
           this.sidesList = sides.stream()
                    .map(sidesMap::get)
                    .collect(Collectors.toList());
           return this;
        }

        public Builder withExtraChees(boolean chees){
            this.extraChees = chees;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }

    public List<Sides> getSidesList() {
        return sidesList;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public PizzaName getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(PizzaName pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSidesList(List<Sides> sidesList) {
        this.sidesList = sidesList;
    }

    public boolean isExtraChees() {
        return extraChees;
    }

    public void setExtraChees(boolean extraChees) {
        this.extraChees = extraChees;
    }
}
