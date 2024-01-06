package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ConsumerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerAddressRepository extends JpaRepository<ConsumerAddress,Long> {
}
