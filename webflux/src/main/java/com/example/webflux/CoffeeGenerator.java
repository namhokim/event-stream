package com.example.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@Service
public class CoffeeGenerator {
    private static final int REPEAT = 10;

    public Flux<Coffee> serve() {
        return Flux.range(1, REPEAT)
                .delayElements(Duration.ofSeconds(1))
                .map(id -> new Coffee());
    }
}
