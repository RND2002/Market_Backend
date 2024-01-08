package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("SERVICE_PROVIDER")
public class ServiceProvider extends UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//
//    @NotBlank(message = "Username cannot be blank")
//    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
//    @Column(unique = true)
//    private String username;
//
//    @NotBlank(message = "Password cannot be blank")
//    @Size(min = 6, message = "Password must be at least 6 characters")
//    private String password;




    @OneToMany(mappedBy = "serviceProvider")
    @JsonIgnore
    private List<ProviderAddress> providerAddresses;

    @OneToMany(mappedBy = "serviceProvider")
    @JsonIgnore
    private List<ProviderSubscription> subscriptions;

    @OneToOne(mappedBy = "serviceProvider")
    @JsonIgnore
    private ProviderDetails providerDetails;

    @OneToMany(mappedBy = "serviceProvider")
    @JsonIgnore
    private List<JobRequest> jobRequest;

    private String role="ROLE_SERVICE_PROVIDER";




}
