package com.palle;

import com.google.common.collect.ImmutableMap;
import com.palle.entity.Pizza;

import java.util.concurrent.atomic.AtomicInteger;

import static com.palle.datastructure.CollectionData.*;

public class Inventory {



    private final AtomicInteger deluxVeggie = new AtomicInteger(10);
    private final AtomicInteger cheeseAndCorn = new AtomicInteger(10);
    private final AtomicInteger paneerTikka = new AtomicInteger(10);
    private final AtomicInteger nonVegSupreme = new AtomicInteger(10);
    private final AtomicInteger chickenTikka = new AtomicInteger(10);

    private final AtomicInteger newHandTossed = new AtomicInteger(10);
    private final AtomicInteger wheatThinCrust = new AtomicInteger(10);
    private final AtomicInteger cheeseBurst = new AtomicInteger(10);
    private final AtomicInteger freshPanPizza = new AtomicInteger(10);
    private final AtomicInteger blackOlive = new AtomicInteger(10);
    private final AtomicInteger capsicum = new AtomicInteger(10);
    private final AtomicInteger paneer = new AtomicInteger(2);
    private final AtomicInteger mushroom = new AtomicInteger(10);
    private final AtomicInteger freshTomato = new AtomicInteger(10);
    private final AtomicInteger barbequeChicken = new AtomicInteger(10);
    private final AtomicInteger grilledChicken = new AtomicInteger(10);
    private final AtomicInteger coldDrink = new AtomicInteger(10);
    private final AtomicInteger mousseCake = new AtomicInteger(10);

    private final ImmutableMap<String, AtomicInteger> pizzaNameMap = ImmutableMap.<String,AtomicInteger>builder()
            .put(DELUXE_VEGGIE,deluxVeggie)
            .put(CHEESE_AND_CORN,cheeseAndCorn)
            .put(CHICKEN_TIKKA,chickenTikka)
            .put(NON_VEG_SUPREME,nonVegSupreme)
            .build();

    private final ImmutableMap<String, AtomicInteger> crustMap = ImmutableMap.<String,AtomicInteger>builder()
            .put(NEW_HAND_TOSSED,newHandTossed)
            .put(WHEAT_THIN_CRUST,wheatThinCrust)
            .put(CHEESE_BURST,cheeseBurst)
            .put(FRESH_PAN_PIZZA,freshPanPizza)
            .build();


    private final ImmutableMap<String, AtomicInteger> toppingMap = ImmutableMap.<String,AtomicInteger>builder()
            .put(BLACK_OLIVE,blackOlive)
            .put(CAPSICUM,capsicum)
            .put(FRESH_TOMATO,freshTomato)
            .put(BARBEQUE_CHICKEN,barbequeChicken)
            .put(GRILLED_CHICKEN,grilledChicken)
            .put(PANEER,paneer)
            .put(MUSHROOM,mushroom)
            .build();

    private final ImmutableMap<String, AtomicInteger> sidesMap = ImmutableMap.<String,AtomicInteger>builder()
            .put(COLD_DRINK,coldDrink)
            .put(MOUSSE_CAKE,mousseCake)
            .build();

    public void checkAvailability(Pizza pizza){

        checkAvailabilty(pizza.getPizzaName().name().toLowerCase(), pizzaNameMap);
        checkAvailabilty(pizza.getCrust().name().toLowerCase(), crustMap);
        pizza.getToppings()
                .forEach(e-> checkAvailabilty(e.name().toLowerCase(),toppingMap));
        pizza.getSidesList()
                .forEach(e-> checkAvailabilty(e.name().toLowerCase(),sidesMap));
    }

    public void setDeluxVeggie(int deluxVeggieCount) {

        this.deluxVeggie.addAndGet(deluxVeggieCount);
    }

    public void setCheeseAndCorn(int cheeseAndCornCount) {

        this.cheeseAndCorn.addAndGet(cheeseAndCornCount);
    }

    public void setPaneerTikka(int paneerTikkaCount)
    {
        this.paneerTikka.addAndGet(paneerTikkaCount);
    }

    public void setNonVegSupreme(int nonVegSupremeCount)
    {
        this.nonVegSupreme.addAndGet(nonVegSupremeCount);
    }

    public void setChickenTikka(int chickenTikkaCount)
    {
        this.chickenTikka.addAndGet( chickenTikkaCount );
    }

    public void setNewHandTossed(int newHandTossedCount)
    {
        this.newHandTossed.addAndGet( newHandTossedCount);
    }

    public void setWheatThinCrust(int wheatThinCrustCount)
    {
        this.wheatThinCrust.addAndGet(wheatThinCrustCount);
    }

    public void setCheeseBurst(int cheeseBurstCount)
    {
        this.cheeseBurst.addAndGet(cheeseBurstCount);
    }

    public void setFreshPanPizza(int freshPanPizzaCount) {
        this.freshPanPizza.addAndGet(freshPanPizzaCount);
    }

    public void setBlackOlive(int blackOliveCount)
    {
        this.blackOlive.addAndGet( blackOliveCount);
    }

    public void setCapsicum(int capsicumCount)
    {
        this.capsicum.addAndGet(capsicumCount);
    }

    public void setPaneer(int paneerCount)
    {
        this.paneer.addAndGet( paneerCount);
    }

    public void setMushroom(int mushroomCount)
    {
        this.mushroom.addAndGet( mushroomCount);
    }

    public void setFreshTomato(int freshTomatoCount)
    {
        this.freshTomato.addAndGet( freshTomatoCount);
    }

    public void setBarbequeChicken(int barbequeChickenCount)
    {
        this.barbequeChicken.addAndGet( barbequeChickenCount);
    }

    public void setGrilledChicken(int grilledChickenCount)
    {
        this.grilledChicken.addAndGet(grilledChickenCount);
    }

    public void setColdDrink(int coldDrinkCount)
    {
        this.coldDrink.addAndGet(coldDrinkCount);
    }

    public void setMousseCake(int mousseCakeCount)
    {
        this.mousseCake.addAndGet( mousseCakeCount);
    }

    public AtomicInteger getDeluxVeggie() {
        return deluxVeggie;
    }

    public AtomicInteger getCheeseAndCorn() {
        return cheeseAndCorn;
    }

    public AtomicInteger getPaneerTikka() {
        return paneerTikka;
    }

    public AtomicInteger getNonVegSupreme() {
        return nonVegSupreme;
    }

    public AtomicInteger getChickenTikka() {
        return chickenTikka;
    }

    public AtomicInteger getNewHandTossed() {
        return newHandTossed;
    }

    public AtomicInteger getWheatThinCrust() {
        return wheatThinCrust;
    }

    public AtomicInteger getCheeseBurst() {
        return cheeseBurst;
    }

    public AtomicInteger getFreshPanPizza() {
        return freshPanPizza;
    }

    public AtomicInteger getBlackOlive() {
        return blackOlive;
    }

    public AtomicInteger getCapsicum() {
        return capsicum;
    }

    public AtomicInteger getPaneer() {
        return paneer;
    }

    public AtomicInteger getMushroom() {
        return mushroom;
    }

    public AtomicInteger getFreshTomato() {
        return freshTomato;
    }

    public AtomicInteger getBarbequeChicken() {
        return barbequeChicken;
    }

    public AtomicInteger getGrilledChicken() {
        return grilledChicken;
    }

    public AtomicInteger getColdDrink() {
        return coldDrink;
    }

    public AtomicInteger getMousseCake() {
        return mousseCake;
    }


    private void checkAvailabilty(String pizzaName, ImmutableMap<String, AtomicInteger> map) {
        AtomicInteger pizzaNameCount = map.get(pizzaName);
        if (pizzaNameCount.get() == 0) {
            throw new RuntimeException();
        }
        pizzaNameCount.decrementAndGet();
    }



}
