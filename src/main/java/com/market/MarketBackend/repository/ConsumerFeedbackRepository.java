package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.ConsumerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerFeedbackRepository extends JpaRepository<ConsumerFeedback,Long> {
}
