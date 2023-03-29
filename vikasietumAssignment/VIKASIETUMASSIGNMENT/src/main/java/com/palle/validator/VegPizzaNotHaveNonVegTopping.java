package com.palle.validator;

import com.palle.entity.Pizza;
import com.palle.entity.PizzaType;
import com.palle.entity.Toppings;

public class VegPizzaNotHaveNonVegTopping implements Validator {

    public void execute(Pizza pizza) {
        if (pizza.getPizzaType().equals(PizzaType.VEG)){

            for (Toppings toppings:pizza.getToppings()){
                if (toppings.getPizzaType().equals(PizzaType.NON_VEG)){
                    throw new RuntimeException("Vegetarian pizza cannot have a non-vegetarian topping.");
                }
            }

        }

    }
}
