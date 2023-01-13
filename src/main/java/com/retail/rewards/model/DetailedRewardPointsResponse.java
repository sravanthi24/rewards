package com.retail.rewards.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DetailedRewardPointsResponse {

	private BigDecimal totalRewards;
	private List<RewardPointsResponse> monthlyRewardPoints;

}
