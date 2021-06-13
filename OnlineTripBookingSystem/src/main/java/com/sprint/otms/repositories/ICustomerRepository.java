package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint.otms.models.Customer;

/**
 * 
 * @author Shourya
 *
 */
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	/**
	 * @param emailId
	 * @return
	 */
	Customer findByEmail(String emailId);

}
