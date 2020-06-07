package com.cache.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cache.poc.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
