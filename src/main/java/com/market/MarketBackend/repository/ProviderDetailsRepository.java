package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ProviderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderDetailsRepository extends JpaRepository<ProviderDetails,Long> {
}
