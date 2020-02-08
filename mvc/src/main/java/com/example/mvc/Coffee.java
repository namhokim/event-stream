package com.example.mvc;

import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Coffee {
    private enum CoffeeFlavor {
        ESPRESSO("Espresso"),
        AMERICANO("Americano"),
        CAFE_LATTE("Cafe Latte"),
        CAPPUCCINO("Cappuccino"),
        CAFE_MOCHA("Cafe Mocha");

        private String name;

        CoffeeFlavor(String name) {
            this.name = name;
        }

        public static String randomCoffeeName() {
            final int selected = ThreadLocalRandom.current().nextInt(CoffeeFlavor.values().length);
            int i = 0;
            for (CoffeeFlavor coffeeFlavor : CoffeeFlavor.values()) {
                if (i==selected) {
                    return coffeeFlavor.name;
                }
                i++;
            }
            return null;
        }
    }

    @Getter
    private UUID id;
    @Getter
    private String name;

    public Coffee() {
        this.id = UUID.randomUUID();
        this.name = CoffeeFlavor.randomCoffeeName();
    }
}
