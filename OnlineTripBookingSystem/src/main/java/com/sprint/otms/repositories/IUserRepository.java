package com.sprint.otms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.otms.models.User;

@Repository
public interface IUserRepository extends  JpaRepository<User, Long>{

}
