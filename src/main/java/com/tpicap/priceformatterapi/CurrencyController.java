package com.tpicap.priceformatterapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class CurrencyController {
    private final Logger log = LoggerFactory.getLogger(CurrencyController.class);
    private CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/currencies")
    Collection<Currency> currencies() {
        log.info("Request currencies");
        return currencyRepository.findAll();
    }

    @GetMapping("/currency/{id}")
    ResponseEntity<?> getCurrency(@PathVariable Long id) {
        log.info("Request currency: {}", id);
        Optional<Currency> currency = currencyRepository.findById(id);
        return currency.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
