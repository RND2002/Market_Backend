package com.market.MarketBackend.service;

import com.market.MarketBackend.entity.ServiceProvider;
import com.market.MarketBackend.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public ResponseEntity<String> saveServiceProviderToRepository(ServiceProvider serviceProvider){
        serviceProviderRepository.save(serviceProvider);
        return new ResponseEntity<>("Service Provider Saved Successfully", HttpStatus.OK);
    }
}
