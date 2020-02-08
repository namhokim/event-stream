package com.example.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class CoffeeController {
    private final CoffeeGenerator coffeeGenerator;

    @Autowired
    public CoffeeController(CoffeeGenerator coffeeGenerator) {
        this.coffeeGenerator = coffeeGenerator;
    }

    @GetMapping(name = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter serveCoffee() {
        SseEmitter emitter = new SseEmitter();
        coffeeGenerator.add(emitter);
        return emitter;
    }
}
