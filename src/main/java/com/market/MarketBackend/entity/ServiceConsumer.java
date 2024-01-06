package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceConsumer {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Username can not be blank")
    @Size(min = 3,max=25,message = "username should be within 3 to 25 characters")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "password can not be blank")
    @Size(min = 6,max = 25,message = "password must be within 6 to 25 characters")
    private String password;

    @OneToMany(mappedBy = "serviceConsumer")
    @JsonIgnore
    private List<ConsumerAddress> consumerAddresses;

    @OneToMany(mappedBy = "serviceConsumer")
    @JsonIgnore
    private List<ConsumerFeedback> consumerFeedbacks;

    private String role = "ROLE_USER";


}
