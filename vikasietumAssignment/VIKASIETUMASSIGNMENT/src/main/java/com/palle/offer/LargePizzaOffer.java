package com.palle.offer;

import com.palle.entity.Pizza;
import com.palle.entity.Size;
import com.palle.entity.Toppings;

public class LargePizzaOffer implements Offer{

    @Override
    public Double execute(Pizza pizza) {
        double sum = 0;
        if (pizza.getSize().equals(Size.LARGE)){
            for (Toppings toppings:pizza.getToppings()){
                sum = sum + toppings.getValue();

            }


        }

        return sum;
    }
}
