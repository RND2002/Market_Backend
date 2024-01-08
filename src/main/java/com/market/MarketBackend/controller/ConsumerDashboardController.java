package com.market.MarketBackend.controller;

import com.market.MarketBackend.entity.ProviderDetails;
import com.market.MarketBackend.service.ServiceConsumerService;
import com.market.MarketBackend.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumerDashboard")
public class ConsumerDashboardController {

    @Autowired
    private ServiceConsumerService serviceConsumerService;

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping("getProviderBycategory")
    public ResponseEntity<List<ProviderDetails>> getServiceProviderByCategory(@RequestParam String jobCategory){
        return serviceConsumerService.getListOfServiceProviderByCategory(jobCategory);
    }


}
