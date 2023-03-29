package com.palle.interactor;

import com.google.common.collect.Lists;
import com.palle.PizzaBean;
import com.palle.entity.Pizza;
import com.palle.validator.NonVegPizzaNotHavePaneerTopping;
import com.palle.validator.Validator;
import com.palle.validator.VegPizzaNotHaveNonVegTopping;
import com.palle.validator.OneNonVegToppingOnNonVegPizza;

import java.util.ArrayList;

public class PizzaService {

    public Pizza makePizza(PizzaBean pizzaBean){
        return new Pizza.Builder()
                .withPizzaType(pizzaBean.getPizzaType())
                .withPizzaName(pizzaBean.getPizzaName())
                .withCrust(pizzaBean.getCrustType())
                .withToppings(pizzaBean.getTopings())
                .withSize(pizzaBean.getSize())
                .withSides(pizzaBean.getSides())
                .withExtraChees(pizzaBean.isExtraChees())
                .build();
    }


    public void verifyPizaa(Pizza pizza){
        ArrayList<Validator> validators = Lists.newArrayList(new NonVegPizzaNotHavePaneerTopping(),
                new OneNonVegToppingOnNonVegPizza(), new VegPizzaNotHaveNonVegTopping());

        for (Validator e : validators) {
            e.execute(pizza);
        }
    }






}
