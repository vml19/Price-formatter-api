package com.tpicap.priceformatterapi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bid_price_id")
    private Price bidPrice;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "offer_price_id")
    private Price offerPrice;
}