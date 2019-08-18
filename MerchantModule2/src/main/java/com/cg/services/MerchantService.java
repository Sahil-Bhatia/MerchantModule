package com.cg.services;

import java.util.List;

import com.cg.entities.Merchant;

public interface MerchantService {
	
	public void addMerchant(Merchant merchantObject);
	public void removeMerchant(Merchant merchantobject);
	public Merchant findMerchantByEmail(String merchantEmailId);
	public List<Merchant> getAllMerchant();
	public void updateMerchant(Merchant merchantObject);
	public Merchant findMerchantById(Integer merchantId);
	
}
