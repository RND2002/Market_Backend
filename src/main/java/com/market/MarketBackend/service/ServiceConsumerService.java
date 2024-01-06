package com.market.MarketBackend.service;

import com.market.MarketBackend.entity.ServiceConsumer;
import com.market.MarketBackend.repository.ConsumerAddressRepository;
import com.market.MarketBackend.repository.ServiceConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceConsumerService {

    @Autowired
    private ServiceConsumerRepository serviceConsumerRepository;

    @Autowired
    private ConsumerAddressRepository consumerAddressRepository;

    public ResponseEntity<String> saveConsumerToRepository(ServiceConsumer serviceConsumer){
        serviceConsumerRepository.save(serviceConsumer);
        return new ResponseEntity<>("Consumer saved to database to repository", HttpStatus.OK);
    }

//    @PostMapping("/jpa/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
//
//        User savedUser = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }

}
