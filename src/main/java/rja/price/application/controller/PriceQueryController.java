package rja.price.application.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import rja.price.domain.entity.Price;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@RequestMapping("/price")
public class PriceQueryController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Price> getPrice(@PathVariable(value = "id") String priceId) {
        return Mono.just(new Price(
                priceId,
                new BigDecimal(new BigInteger("1020"), 2))
        );
    }

    @GetMapping
    public Mono<String> getPrices() {
        return Mono.just("Prices");
    }
}
