package com.retail.rewards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "reward_points")
@Entity
@Data
public class RewardPoint {

	@Column(name = "amount_limit")
	private BigDecimal amountLimit;

	@Column(name = "points")
	private Integer points;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "HIBERNATE_SEQUENCE", initialValue = 1)
	@JsonIgnore
	private int Id;

}
