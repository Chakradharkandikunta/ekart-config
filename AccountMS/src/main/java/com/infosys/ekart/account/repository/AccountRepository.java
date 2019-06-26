package com.infosys.ekart.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.ekart.account.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<User, String> {

	User findByEmailId(String emailId);

}
