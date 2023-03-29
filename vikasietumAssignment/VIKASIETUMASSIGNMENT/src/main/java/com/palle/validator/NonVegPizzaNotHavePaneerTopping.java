package com.palle.validator;

import com.palle.entity.Pizza;
import com.palle.entity.PizzaType;
import com.palle.entity.Toppings;

public class NonVegPizzaNotHavePaneerTopping implements Validator{

    public void execute(Pizza pizza) {
        if (pizza.getPizzaType().equals(PizzaType.NON_VEG)){

            for (Toppings toppings:pizza.getToppings()){
                if (toppings.equals(Toppings.Paneer)){
                    throw new RuntimeException("Non-vegetarian pizza cannot have paneer topping.");
                }
            }
        }
    }
}
