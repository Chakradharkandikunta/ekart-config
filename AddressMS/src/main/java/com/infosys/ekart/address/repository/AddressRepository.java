package com.infosys.ekart.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.ekart.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByUserId(String userId);
	
	Address findByAddressIdAndUserId(Integer addressId,String userId);
}
