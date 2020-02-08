package com.example.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CoffeeController {
    private final CoffeeGenerator coffeeGenerator;

    @Autowired
    public CoffeeController(CoffeeGenerator coffeeGenerator) {
        this.coffeeGenerator = coffeeGenerator;
    }

    @GetMapping(name = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Coffee> serveCoffee() {
        return coffeeGenerator.serve();
    }
}
