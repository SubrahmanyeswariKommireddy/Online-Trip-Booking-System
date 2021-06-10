package com.sprint.otms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint.otms.models.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String emailId);

	//Optional<Customer> findOne(String userName);

}
