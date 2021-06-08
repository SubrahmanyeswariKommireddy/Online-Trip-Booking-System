package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Long> {

}
