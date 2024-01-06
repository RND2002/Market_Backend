package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ProviderSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderSubscriptionRepository extends JpaRepository<ProviderSubscription,Long> {
}
