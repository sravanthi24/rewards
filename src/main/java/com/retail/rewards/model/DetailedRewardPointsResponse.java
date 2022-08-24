package com.retail.rewards.model;

import lombok.Data;

import java.util.List;

@Data
public class DetailedRewardPointsResponse {

    private long totalRewards;
    List<RewardPointsResponse> monthlyRewardPoints;

}
