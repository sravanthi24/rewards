package com.retail.rewards.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RewardPointsResponse {
	private String monthYear;
	private BigDecimal rewardPoints;

}
