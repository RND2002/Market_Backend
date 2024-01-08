package com.market.MarketBackend.controller;

import com.market.MarketBackend.entity.ConsumerAddress;
import com.market.MarketBackend.entity.ConsumerFeedback;
import com.market.MarketBackend.entity.ServiceConsumer;
import com.market.MarketBackend.service.ServiceConsumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consumer")
public class ServiceConsumerController {

    @Autowired
    private ServiceConsumerService serviceConsumerService;

    @PostMapping("saveCredentials")
    public ResponseEntity<String> saveCustomerCredentials(@Valid @RequestBody ServiceConsumer serviceConsumer){
        return serviceConsumerService.saveConsumerToRepository(serviceConsumer);
    }

    @PostMapping("saveAddress/{id}")
    public ResponseEntity<String> saveCustomerAddress(@PathVariable Long id, @Valid @RequestBody ConsumerAddress  consumerAddress){
        return serviceConsumerService.saveConsumerAddressToRepository(id,consumerAddress);
    }

    @PostMapping("saveFeedback/{id}")
    public ResponseEntity<String> saveCustomerFeedback(@PathVariable Long id, @Valid @RequestBody ConsumerFeedback consumerFeedback){
        return serviceConsumerService.saveConsumerFeedbackToRepository(id,consumerFeedback);
    }


}
