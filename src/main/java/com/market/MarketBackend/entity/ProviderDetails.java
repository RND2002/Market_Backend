package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDetails {
    @Id
    private long id;

    @Size(min = 3,max = 25,message = "Name of Service Provider or his shop is necessary")
    @NotBlank(message = "name is mendatory")
    private String identificationName;

    @NotBlank(message = "Job category cannot be blank")
    private String jobCategory;

    @NotBlank(message = "Job category cannot be blank")
    private String jobDescription;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;


    @NotBlank(message = "Job category cannot be blank")
    private String expectedCharge;

    @OneToOne
    @JsonIgnore
    private ServiceProvider serviceProvider;
}
