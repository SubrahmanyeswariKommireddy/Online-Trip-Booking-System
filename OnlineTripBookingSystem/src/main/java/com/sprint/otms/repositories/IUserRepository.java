package com.sprint.otms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.User;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Repository
public interface IUserRepository extends  JpaRepository<User, Long>{
	
@Query("SELECT  u FROM User u Where u.email=?1")
public List<User> findByEmail(String email);
}
