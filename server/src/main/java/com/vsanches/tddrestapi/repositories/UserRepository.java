package com.vsanches.tddrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsanches.tddrestapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
