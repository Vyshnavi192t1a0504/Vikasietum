package com.palle.interactor;

import com.palle.entity.Pizza;
import com.palle.entity.Sides;
import com.palle.entity.Toppings;
import com.palle.offer.LargePizzaOffer;

import static com.palle.datastructure.CollectionData.priceingTable;

public class PricingService {


    public double totalPrice(Pizza pizza){

        double toppingPrice = pizza.getToppings().stream()
                .mapToDouble(Toppings::getValue)
                .sum();
        double sidesPrice = pizza.getSidesList().stream()
                .mapToDouble(Sides::getValue)
                .sum();
        double cheesPrice = pizza.isExtraChees() ? 35.0 : 0;
        Double offerPrice = new LargePizzaOffer().execute(pizza);
        Double pizzaPrice = priceingTable.get(pizza.getPizzaName(), pizza.getSize());

        return pizzaPrice+ toppingPrice+ sidesPrice - offerPrice + cheesPrice;

    }
}
