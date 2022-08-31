package com.tpicap.priceformatterapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Price {

    @Id
    @GeneratedValue
    private Long id;
    private String bigFigure;
    private String dealingPrice;
    private String fractionalPips;
}