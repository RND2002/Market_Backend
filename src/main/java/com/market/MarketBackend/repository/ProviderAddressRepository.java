package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ProviderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderAddressRepository extends JpaRepository<ProviderAddress,Long> {
}
