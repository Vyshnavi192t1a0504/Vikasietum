package com.palle.interactor;

import com.google.common.collect.Lists;
import com.palle.PizzaBean;
import com.palle.entity.*;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.palle.entity.Crust.NewHandTossed;
import static com.palle.entity.Crust.WheatThinCrust;
import static com.palle.entity.PizzaName.DeluxeVeggie;
import static com.palle.entity.PizzaName.PepperBarbecueChicken;
import static com.palle.entity.Toppings.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PizzaServiceTest {

    private static final String VEG = "veg";

    private static final String DELUXE_VEGGIE = "deluxeveggie";
    private static final String NEW_HAND_TOSSED = "newhandtossed";
    private static final String COLD_DRINK = "colddrink";
    private static final String BLACK_OLIVE = "BlackOlive";
    private static final String CAPSICUM = "Capsicum";
    private static final String REGULAR = "regular";

    private final PizzaService pizzaService = new PizzaService();



    @Test
    public void shouldConvertPizzaBeanToPizza() {
        List<String> sides = Lists.newArrayList(COLD_DRINK);
        ArrayList<String> toppings = Lists.newArrayList(BLACK_OLIVE, CAPSICUM);
        PizzaBean pizzaBean = buildPizzaBean(VEG, REGULAR, NEW_HAND_TOSSED, sides, DELUXE_VEGGIE, toppings);

        Pizza pizza = pizzaService.makePizza(pizzaBean);

        assertThat(pizza.getCrust(), is(NewHandTossed));
        assertThat(pizza.getToppings(),hasSize(2));
        assertThat(pizza.getPizzaType(), Matchers.is(PizzaType.VEG));
        assertThat(pizza.getSize(), Matchers.is(Size.REGULAR));
        assertThat(pizza.getSidesList(),hasSize(1));
    }

    @Test(expected = RuntimeException.class)
    public void nonVegPizzaCannotHavePannerToppings() {
        ArrayList<Toppings> toppings = Lists.newArrayList(Paneer);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = buildPizza(PizzaType.NON_VEG, PepperBarbecueChicken, Size.MEDIUM, WheatThinCrust, toppings,sides,false);

        pizzaService.verifyPizaa(pizza);
    }

    @Test(expected = RuntimeException.class)
    public void vegPizzaCannotNonVegTopping() {
        ArrayList<Toppings> toppings = Lists.newArrayList(BarbequeChicken);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = buildPizza(PizzaType.VEG, DeluxeVeggie, Size.MEDIUM, WheatThinCrust, toppings,sides,false);

        pizzaService.verifyPizaa(pizza);
    }

    @Test(expected = RuntimeException.class)
    public void nonVegPizzaCanHaveOnlyOneNonVegTopping() {

        ArrayList<Toppings> toppings = Lists.newArrayList(BarbequeChicken,ChickenTikka_T);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = buildPizza(PizzaType.VEG, DeluxeVeggie, Size.MEDIUM, WheatThinCrust, toppings,sides,false);

        pizzaService.verifyPizaa(pizza);

    }

    @Test
    public void shouldNotThrowExceptionWhenPizzaFollowAllTheRule() {
        ArrayList<Toppings> toppings = Lists.newArrayList(Paneer);
        ArrayList<Sides> sides = Lists.newArrayList(Sides.Colddrink);
        Pizza pizza = buildPizza(PizzaType.VEG, PepperBarbecueChicken, Size.MEDIUM, WheatThinCrust, toppings,sides,false);

        pizzaService.verifyPizaa(pizza);
    }

    public Pizza buildPizza(PizzaType nonVeg, PizzaName pepperBarbecueChicken, Size medium, Crust wheatThinCrust,
                            ArrayList<Toppings> toppings,ArrayList<Sides> sides,boolean extraChees) {
        Pizza pizza = new Pizza();
        pizza.setPizzaType(nonVeg);
        pizza.setPizzaName(pepperBarbecueChicken);
        pizza.setCrust(wheatThinCrust);
        pizza.setSize(medium);
        pizza.setToppings(toppings);
        pizza.setSidesList(sides);
        pizza.setExtraChees(extraChees);
        return pizza;
    }

    private PizzaBean buildPizzaBean(String veg, String regular, String newHandTossed, List<String> sides, String deluxeVeggie, ArrayList<String> toppings) {
        PizzaBean pizzaBean = new PizzaBean();
        pizzaBean.setPizzaType(veg);
        pizzaBean.setPizzaName(deluxeVeggie);
        pizzaBean.setCrustType(newHandTossed);
        pizzaBean.setExtraCheese(true);
        pizzaBean.setSides(sides);
        pizzaBean.setTopings(toppings);
        pizzaBean.setSize(regular);
        return pizzaBean;
    }
}