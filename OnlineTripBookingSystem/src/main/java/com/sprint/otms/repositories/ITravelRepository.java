package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.otms.models.Travel;

public interface ITravelRepository extends JpaRepository<Travel, Long> {

}
