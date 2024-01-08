package com.market.MarketBackend.service;

import com.market.MarketBackend.entity.ProviderAddress;
import com.market.MarketBackend.entity.ProviderDetails;
import com.market.MarketBackend.entity.ProviderSubscription;
import com.market.MarketBackend.entity.ServiceProvider;
import com.market.MarketBackend.repository.ProviderAddressRepository;
import com.market.MarketBackend.repository.ProviderDetailsRepository;
import com.market.MarketBackend.repository.ProviderSubscriptionRepository;
import com.market.MarketBackend.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private ProviderAddressRepository providerAddressRepository;

    @Autowired
    private ProviderDetailsRepository providerDetailsRepository;

    @Autowired
    private ProviderSubscriptionRepository providerSubscriptionRepository;

    public ResponseEntity<String> saveServiceProviderToRepository(ServiceProvider serviceProvider){
        serviceProviderRepository.save(serviceProvider);
        return new ResponseEntity<>("Service Provider Saved Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> saveServiceProviderAddressToRepository(Long providerId,ProviderAddress providerAddress){
        ServiceProvider serviceProvider=serviceProviderRepository.findById(providerId).orElseThrow();
        providerAddress.setServiceProvider(serviceProvider);
        providerAddressRepository.save(providerAddress);
        return new ResponseEntity<>("Address of Service Provider is saved",HttpStatus.OK);
    }

    public ResponseEntity<String> saveProviderDetailsToRepository(Long providerId, ProviderDetails providerDetails){
        ServiceProvider serviceProvider=serviceProviderRepository.findById(providerId).orElseThrow();
        providerDetails.setServiceProvider(serviceProvider);
        providerDetailsRepository.save(providerDetails);
        return new ResponseEntity<>("Provider's details is saved to Repository",HttpStatus.OK);
    }

    public ResponseEntity<String> saveProviderSubscriptionToRepository(Long providerId, ProviderSubscription providerSubscription){
        ServiceProvider serviceProvider=serviceProviderRepository.findById(providerId).orElseThrow();
        providerSubscription.setServiceProvider(serviceProvider);
        providerSubscriptionRepository.save(providerSubscription);
        return new ResponseEntity<>("Subscription Data is added",HttpStatus.OK);
    }


//    public ResponseEntity<String> updateProviderAddress(Long id, ProviderAddress providerAddress) {
//        ServiceProvider serviceProvider=serviceProviderRepository.findById(id).orElseThrow();
//        ProviderAddress providerAddress1=serviceProvider.getProviderAddresses().;
//    }
}
