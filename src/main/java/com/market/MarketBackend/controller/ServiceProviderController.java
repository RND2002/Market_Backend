package com.market.MarketBackend.controller;

import com.market.MarketBackend.entity.ProviderAddress;
import com.market.MarketBackend.entity.ServiceProvider;
import com.market.MarketBackend.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("provider")
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;


    @PostMapping("saveCredentials")
    public ResponseEntity<String> addServiceProvider(@RequestBody ServiceProvider serviceProvider){
        return serviceProviderService.saveServiceProviderToRepository(serviceProvider);
    }

    @PostMapping("saveAddress/{id}")
    public ResponseEntity<String> saveAddressOfProvider(@PathVariable Long id, @RequestBody ProviderAddress providerAddress){
        return serviceProviderService.saveServiceProviderAddressToRepository(id,providerAddress);
    }

}
