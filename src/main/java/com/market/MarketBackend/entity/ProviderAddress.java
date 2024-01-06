package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProviderAddress {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Street / village can not be blank")
    @Size(min = 3,max = 50,message = "Street must be within 3 to 50 characters")
    private String street;
    @NotBlank(message = "city can not be blank")
    @Size(min = 3,max = 25,message = "City must be within 3 to 50 characters")
    private String city;
    @NotBlank(message = "State can not be blank")
    @Size(min = 3,max = 50,message = "State must be within 3 to 50 characters")
    private String state;

    @ManyToOne
    @JsonIgnore
    private ServiceProvider serviceProvider;
}
