package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ProviderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderDetailsRepository extends JpaRepository<ProviderDetails,Long> {
    List<ProviderDetails> findByJobCategory(String jobCategory);
}
