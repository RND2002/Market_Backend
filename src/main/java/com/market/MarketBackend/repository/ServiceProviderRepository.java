package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ProviderDetails;
import com.market.MarketBackend.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Long> {

}
