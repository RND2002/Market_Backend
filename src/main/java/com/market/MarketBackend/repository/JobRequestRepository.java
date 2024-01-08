package com.market.MarketBackend.repository;

import com.market.MarketBackend.entity.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequestRepository extends JpaRepository<JobRequest,Long> {
}
