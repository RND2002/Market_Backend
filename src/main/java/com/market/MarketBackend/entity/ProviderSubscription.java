package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProviderSubscription {
    @Id
    @GeneratedValue
    private long id;



    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ServiceProvider serviceProvider;


}
