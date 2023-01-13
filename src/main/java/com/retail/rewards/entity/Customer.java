package com.retail.rewards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "customer")
@Entity
@Data
@ToString
public class Customer implements Serializable {

	@Id
	@Column(name = "customer_id", nullable = false)
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "HIBERNATE_SEQUENCE", initialValue = 1)
	private Long customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
	@Transient
	@JsonIgnore
	private Set<TransactionData> transactions;

}
