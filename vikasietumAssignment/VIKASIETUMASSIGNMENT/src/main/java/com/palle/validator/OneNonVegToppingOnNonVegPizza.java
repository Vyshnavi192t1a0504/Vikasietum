package com.palle.validator;

import com.palle.entity.Pizza;
import com.palle.entity.PizzaType;

public class OneNonVegToppingOnNonVegPizza implements Validator {

    @Override
    public void execute(Pizza pizza) {
        if (pizza.getPizzaType().equals(PizzaType.NON_VEG)){
            long numberOfNonVegTopping = pizza.getToppings().stream()
                    .filter(e -> e.getPizzaType().equals(PizzaType.NON_VEG))
                    .count();
            if (numberOfNonVegTopping > 1){
                throw new RuntimeException("You can add only one of the non-veg toppings in non-vegetarian pizza.");
            }
        }
    }
}
