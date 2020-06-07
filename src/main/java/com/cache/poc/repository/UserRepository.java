package com.cache.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cache.poc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
