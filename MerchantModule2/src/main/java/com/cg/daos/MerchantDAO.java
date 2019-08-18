package com.cg.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Merchant;

@Repository
public interface MerchantDAO extends JpaRepository<Merchant, Integer> {
	
	@Query("SELECT m FROM Merchant m WHERE m.emailid = ?1")
	public  Merchant existsByEmailId(String emailId);
}
