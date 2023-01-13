package com.retail.rewards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "transaction")
@Entity
@Data
@ToString
public class TransactionData {

	@Id
	@Column(name = "transaction_id", nullable = false)
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "HIBERNATE_SEQUENCE", initialValue = 1)
	private Long transactionId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private Customer customerId;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	@Column(name = "bill_amount")
	private BigDecimal billAmount;

	@Column(name = "reward_points")
	private BigDecimal rewardPoints;

	@Transient
	@JsonIgnore
	private Long count;

}
