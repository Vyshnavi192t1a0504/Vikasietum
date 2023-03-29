package com.palle.interactor;

import com.google.common.collect.Lists;
import com.palle.entity.Pizza;
import com.palle.entity.PizzaType;
import com.palle.entity.Size;
import com.palle.entity.Sides;
import com.palle.entity.Toppings;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static com.palle.entity.Crust.WheatThinCrust;
import static com.palle.entity.PizzaName.DeluxeVeggie;
import static com.palle.entity.Toppings.BarbequeChicken;
import static com.palle.entity.Toppings.ChickenTikka_T;
import static org.hamcrest.Matchers.is;

public class PricingServiceTest {


    final PricingService pricingService = new PricingService();


    @Test
    public void calculatePriceWithMultipleTopping() {
        ArrayList<Toppings> toppings = Lists.newArrayList(BarbequeChicken,ChickenTikka_T);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = new PizzaServiceTest().buildPizza(PizzaType.VEG, DeluxeVeggie, Size.MEDIUM, WheatThinCrust, toppings
        ,sides,false);

        double totalPrice = pricingService.totalPrice(pizza);

        Assert.assertThat(totalPrice, is(335.0));
    }

    @Test
    public void calculatePriceForExtraCheesPizza() {

        ArrayList<Toppings> toppings = Lists.newArrayList(BarbequeChicken,ChickenTikka_T);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = new PizzaServiceTest().buildPizza(PizzaType.VEG, DeluxeVeggie, Size.MEDIUM, WheatThinCrust, toppings
                ,sides,true);

        double totalPrice = pricingService.totalPrice(pizza);

        Assert.assertThat(totalPrice, is(370.0));
    }
}