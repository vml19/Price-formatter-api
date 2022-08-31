package com.tpicap.priceformatterapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final CurrencyRepository repository;

    public Initializer(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("USD", "PHP", "GBP").forEach(name ->
                repository.save(new Currency(name))
        );

        //USD
        Currency usd = repository.findByName("USD");
        Price bidUsd = Price.builder().bigFigure("3.34")
                .dealingPrice("8.23")
                .fractionalPips("4.90")
                .build();
        usd.setBidPrice(bidUsd);
        Price offerUsd = Price.builder().bigFigure("2.94")
                .dealingPrice("7.73")
                .fractionalPips("3.83")
                .build();
        usd.setOfferPrice(offerUsd);
        repository.save(usd);

        //PHP
        Currency php = repository.findByName("PHP");
        Price bidPhp = Price.builder().bigFigure("33.345")
                .dealingPrice("90.232")
                .fractionalPips("100.122")
                .build();
        php.setBidPrice(bidPhp);
        Price offerPhp = Price.builder().bigFigure("23.22")
                .dealingPrice("53.33")
                .fractionalPips("40.123")
                .build();
        php.setOfferPrice(offerPhp);
        repository.save(php);

        //GBP
        Currency gbp = repository.findByName("GBP");
        Price bidGbp = Price.builder().bigFigure("4.23")
                .dealingPrice("10.22")
                .fractionalPips("11.23")
                .build();
        gbp.setBidPrice(bidGbp);
        Price offerGbp = Price.builder().bigFigure("45.33")
                .dealingPrice("50.33")
                .fractionalPips("60.23")
                .build();
        gbp.setOfferPrice(offerGbp);
        repository.save(gbp);

        repository.findAll().forEach(System.out::println);
    }
}