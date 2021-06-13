package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

	/**
	 * @param emailId
	 * @return
	 */
	Admin findByEmail(String emailId);

}
