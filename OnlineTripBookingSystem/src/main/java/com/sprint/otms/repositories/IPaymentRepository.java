package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Payment;

/**
 * 
 * @author Satish
 *
 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
