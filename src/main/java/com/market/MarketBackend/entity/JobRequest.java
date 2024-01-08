package com.market.MarketBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class JobRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "RequestedTo cannot be blank")
    private String requestedTo;

    @NotBlank(message = "JobType cannot be blank")
    private String jobType;

    @NotNull(message = "JobId cannot be null")
    private Long jobId;

    @NotBlank(message = "RequesterName cannot be blank")
    @Size(min = 3, max = 50, message = "RequesterName must be between 3 and 50 characters")
    private String requesterName;

    @NotBlank(message = "Problem cannot be blank")
    private String problem;

    @NotBlank(message = "Phone cannot be blank")
    @Size(min = 10, max = 10, message = "Phone must be of 10 digits")
    private String phone;

    @ManyToOne
    @JsonIgnore
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JsonIgnore
    private ServiceConsumer serviceConsumer;
}
