package com.palle;

import java.util.List;

public class PizzaBean {

    private String pizzaType;
    private String PizzaName;
    private String crustType;
    private List<String> topings;
    private boolean extraCheese;
    private List<String> sides;
    private String size;
    private boolean extraChees;

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getPizzaName() {
        return PizzaName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPizzaName(String pizzaName) {
        PizzaName = pizzaName;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public List<String> getTopings() {
        return topings;
    }

    public void setTopings(List<String> topings) {
        this.topings = topings;
    }



    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public List<String> getSides() {
        return sides;
    }

    public void setSides(List<String> sides) {
        this.sides = sides;
    }

    public boolean isExtraChees() {
        return extraChees;
    }

    public void setExtraChees(boolean extraChees) {
        this.extraChees = extraChees;
    }
}
