package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Travel;

/**
 * 
 * @author Subrahmanyeswari
 *
 */
@Repository
public interface ITravelRepository extends JpaRepository<Travel, Long> {

}
