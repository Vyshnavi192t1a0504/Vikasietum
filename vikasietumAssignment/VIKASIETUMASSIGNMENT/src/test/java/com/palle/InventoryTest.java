package com.palle;

import com.google.common.collect.Lists;
import com.palle.entity.*;
import com.palle.interactor.PizzaServiceTest;
import org.junit.Test;

import java.util.ArrayList;

import static com.palle.entity.Crust.WheatThinCrust;
import static com.palle.entity.PizzaName.ChickenTikka;
import static com.palle.entity.Sides.Colddrink;
import static com.palle.entity.Toppings.Paneer;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InventoryTest {

    private final Inventory inventory = new Inventory();

    @Test
    public void shouldNotThrowExceptionWhenAllIngredientAvailable() {
        ArrayList<Toppings> toppings = Lists.newArrayList(Paneer);
        ArrayList<Sides> sides = Lists.newArrayList(Colddrink);
        Pizza pizza = new PizzaServiceTest().buildPizza(PizzaType.VEG, ChickenTikka, Size.MEDIUM,
                WheatThinCrust, toppings,sides,false);

        inventory.checkAvailability(pizza);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenSidesAreNotAvailable() {
        ArrayList<Toppings> toppings = Lists.newArrayList(Paneer);
        ArrayList<Sides> sides = Lists.newArrayList(Colddrink,Colddrink,Colddrink,Colddrink,Colddrink,Colddrink,Colddrink
        ,Colddrink,Colddrink,Colddrink,Colddrink);
        Pizza pizza = new PizzaServiceTest().buildPizza(PizzaType.VEG, ChickenTikka, Size.MEDIUM,
                WheatThinCrust, toppings,sides,false);

        inventory.checkAvailability(pizza);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenToppingIsUnAvailable() {
        ArrayList<Toppings> toppings = Lists.newArrayList(Paneer,Paneer,Paneer);
        ArrayList<Sides> sides = Lists.newArrayList(Colddrink);
        Pizza pizza = new PizzaServiceTest().buildPizza(PizzaType.VEG, ChickenTikka, Size.MEDIUM,
                WheatThinCrust, toppings,sides,false);

        inventory.checkAvailability(pizza);
    }
    
    @Test
    public void userShouldBeAbleToAddCasicumToInventory() {
        int beforeAdding = inventory.getCapsicum().get();
        inventory.setCapsicum(4);

       assertThat(inventory.getCapsicum().get(), is(beforeAdding+ 4));
    }
}
