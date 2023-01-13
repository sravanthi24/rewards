package com.retail.rewards.repository;

import com.retail.rewards.entity.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionData, Long> {
	List<TransactionData> findTransactionDataByCustomerId_PhoneNumber(String phoneNumber);

	@Query(value = "select c.phone_number as phoneNumber, sum(reward_points) as count from customer c, transaction t where c.customer_id = t.cust_id group by t.cust_id "
			+ " ORDER BY count DESC", nativeQuery = true)
	List<Object[]> getCountForAllCustomer();

	@Query(value = "select c.phone_number as phoneNumber, sum(reward_points) as count from customer c, transaction t where c.customer_id = t.cust_id "
			+ " and c.phone_number =?1", nativeQuery = true)
	List<Object[]> getRewardPointsByPhoneNumber(String phoneNumber);

	@Query(value = "select MONTHNAME(t.transaction_date) as monthName,year(t.transaction_date) as yearName, "
			+ "sum(t.reward_points) from transaction t,customer c where "
			+ "c.customer_id = t.cust_id and c.phone_number =?1 and t.transaction_date>?2 group by monthName, "
			+ "yearName order by transaction_date desc", nativeQuery = true)
	List<Object[]> getDetailedRewardPointsByPhoneNumberAndMonths(String phoneNumber, LocalDate date);

}
