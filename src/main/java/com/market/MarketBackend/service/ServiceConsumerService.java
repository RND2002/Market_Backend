package com.market.MarketBackend.service;

import com.market.MarketBackend.entity.*;
import com.market.MarketBackend.repository.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConsumerService {

    @Autowired
    private ServiceConsumerRepository serviceConsumerRepository;

    @Autowired
    private ConsumerAddressRepository consumerAddressRepository;

    @Autowired
    private ConsumerFeedbackRepository consumerFeedbackRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;
    @Autowired
    private ProviderDetailsRepository providerDetailsRepository;

    @Autowired
    private JobRequestRepository jobRequestRepository;

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

    public ResponseEntity<String> saveConsumerAddressToRepository(Long consumerId, ConsumerAddress consumerAddress){
        ServiceConsumer serviceConsumer=serviceConsumerRepository.findById(consumerId).orElseThrow();
        consumerAddress.setServiceConsumer(serviceConsumer);
        consumerAddressRepository.save(consumerAddress);
        return new ResponseEntity<>("Consumer address is added to repository",HttpStatus.OK);
    }

    public ResponseEntity<String> saveConsumerFeedbackToRepository(Long consumerId, ConsumerFeedback consumerFeedback){
        ServiceConsumer serviceConsumer=serviceConsumerRepository.findById(consumerId).orElseThrow();
        consumerFeedback.setServiceConsumer(serviceConsumer);
        consumerFeedbackRepository.save(consumerFeedback);
        return new ResponseEntity<>("Consumer feedback is valuable so saved easily",HttpStatus.OK);
    }

    public ResponseEntity<List<ProviderDetails>> getListOfServiceProviderByCategory(String jobCategory) {
        List<ProviderDetails> providerDetailsLists=providerDetailsRepository.findByJobCategory(jobCategory);
        return new ResponseEntity<>(providerDetailsLists,HttpStatus.OK);
    }

    public ResponseEntity<String> addRequestToJobRequestRepository(Long consumerId, JobRequest jobRequest) {

        ProviderDetails providerDetails=providerDetailsRepository.findById(jobRequest.getJobId()).orElseThrow();
        ServiceProvider serviceProvider=serviceProviderRepository.findById(providerDetails.getId()).orElseThrow();
        ServiceConsumer serviceConsumer=serviceConsumerRepository.findById(consumerId).orElseThrow();
        jobRequest.setServiceProvider(serviceProvider);
        jobRequest.setServiceConsumer(serviceConsumer);
        jobRequestRepository.save(jobRequest);
        return new ResponseEntity<>("Your request have been placed successfully. Sit tight till we catch you",HttpStatus.OK);

    }

    public ResponseEntity<String> deleteJobRequest(JobRequest jobRequest){
        jobRequestRepository.delete(jobRequest);
        return new ResponseEntity<>("Your service has been canceled successfully",HttpStatus.OK);
    }
}
