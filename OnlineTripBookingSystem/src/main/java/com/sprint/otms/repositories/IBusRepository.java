package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.otms.models.Bus;

public interface IBusRepository extends JpaRepository<Bus, Long> {

}
