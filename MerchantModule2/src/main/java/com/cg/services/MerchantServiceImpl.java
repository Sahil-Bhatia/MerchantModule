package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cg.daos.MerchantDAO;
import com.cg.entities.Merchant;
import com.cg.exceptions.ApplicationException;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {
Cryptography c=new Cryptography();
String secretKey="SomeSecretKey";
	@Autowired
	MerchantDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addMerchant(Merchant merchantObject) {

		if (dao.existsByEmailId(merchantObject.getEmailid()) != null) {
			throw new ApplicationException("Merchant Already exists!!");
		}
		String encyptedPassword=c.encrypt(merchantObject.getPassword(),secretKey);
		merchantObject.setPassword(encyptedPassword);
		dao.save(merchantObject);
	}

	public void removeMerchant(Merchant merchantobject) {
		// TODO Auto-generated method stub
		dao.delete(merchantobject);
	}

	public Merchant findMerchantById(Integer merchantId) {
		// TODO Auto-generated method stub
		return dao.findById(merchantId).get();
	}

	public List<Merchant> getAllMerchant() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void updateMerchant(Merchant merchantObject) {
		// TODO Auto-generated method stub
		if (dao.existsByEmailId(merchantObject.getEmailid()) != null) {
			dao.save(merchantObject);
			
		}else {
			throw new ApplicationException("Merchant Not Found for update operation");

		}
	}

	public Merchant findMerchantByEmail(String merchantEmailId) {
		// TODO Auto-generated method stub
		return dao.existsByEmailId(merchantEmailId);
	}

}
