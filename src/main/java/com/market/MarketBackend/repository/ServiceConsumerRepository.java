package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ServiceConsumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceConsumerRepository extends JpaRepository<ServiceConsumer,Long> {
}
