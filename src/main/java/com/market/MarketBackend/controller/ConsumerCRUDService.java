package com.market.MarketBackend.controller;

import com.market.MarketBackend.entity.JobRequest;
import com.market.MarketBackend.service.ServiceConsumerService;
import com.market.MarketBackend.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("crudConsumer")
public class ConsumerCRUDService {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @Autowired
    private ServiceConsumerService serviceConsumerService;
    @PostMapping("requestService/{consumerId}")
    public ResponseEntity<String> requestService(@PathVariable Long consumerId, @RequestBody JobRequest jobRequest){
        return serviceConsumerService.addRequestToJobRequestRepository(consumerId,jobRequest);
    }

    @DeleteMapping("deleteService")
    public ResponseEntity<String> deleteService(@RequestBody JobRequest jobRequest){
        return serviceConsumerService.deleteJobRequest(jobRequest);
    }
}
