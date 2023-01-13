package com.retail.rewards.repository;

import com.retail.rewards.entity.RewardPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardPointRepository extends JpaRepository<RewardPoint, Long> {

	List<RewardPoint> findAllByOrderByAmountLimitDesc();
}
