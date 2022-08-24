package com.retail.rewards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Table(name ="reward_point")
@Entity
@Data
public class RewardPoint {
	
	@Column(name = "amount_limit")
	private Long amountLimit;
	
	@Column(name = "points")
	private int points;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "HIBERNATE_SEQUENCE", initialValue = 1)
	@JsonIgnore
	private int Id;

}
