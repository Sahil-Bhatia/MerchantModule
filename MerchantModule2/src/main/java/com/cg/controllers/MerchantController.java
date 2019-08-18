package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Merchant;
import com.cg.entities.ResponseMessage;
import com.cg.services.MerchantService;

@RestController
@RequestMapping("/merchant")
@CrossOrigin(origins = "http://localhost:4200")
public class MerchantController {
	@Autowired
	MerchantService merchantService;
	
	ResponseMessage resMsg;

	@GetMapping(value = "/")
	public ResponseMessage getAllMerchants() {

		List<Merchant> merchantsList = merchantService.getAllMerchant();
		if(merchantsList==null || merchantsList.isEmpty()) {
		resMsg = new ResponseMessage("Merchant Records Not Found", 404, null, null);
		return resMsg;
		}
		else
		{	System.out.println(merchantsList);
			resMsg = new ResponseMessage("Merchants Record Found", 200, merchantsList, null);
			return resMsg;
		}
		
	}

	@GetMapping(value = "/find/{emailid}")
	public ResponseMessage findByEmailId(@PathVariable String emailid) {

		Merchant merchantObject;
		try {
			merchantObject = merchantService.findMerchantByEmail(emailid);
		} catch (RuntimeException e) {
			resMsg = new ResponseMessage("Merchant Not Found", 404, null, null);
			return resMsg;

		}
		resMsg = new ResponseMessage("Merchant Found", 200, null, merchantObject);
		return resMsg;
	}

	@PostMapping(value = "/new", consumes = { "application/json" })
	public ResponseMessage save(@RequestBody Merchant merchantObject) {

		try {
			merchantService.addMerchant(merchantObject);
		} catch (RuntimeException ex) {
			resMsg = new ResponseMessage("Merchant Already Exists", 409, null, merchantObject);
			return resMsg;

		}
		resMsg = new ResponseMessage("Merchant Record Added", 200, null, merchantObject);
		return resMsg;
	}

	@PutMapping(value = "/update", consumes = { "application/json" })
	public ResponseMessage update(@RequestBody Merchant merchantObject) {

		try {
			merchantService.updateMerchant(merchantObject);
		} catch (RuntimeException e) {
			resMsg = new ResponseMessage("Merchant Record Not Found", 404, null, null);
			return resMsg;

		}resMsg = new ResponseMessage("Merchant Record Updated", 200, null, null);
		return resMsg;
	}

	@DeleteMapping(value = "/delete/{merchantId}")
	public ResponseMessage delete(@PathVariable Integer merchantId) {
		System.out.println("In Delete Request");
		try {
			merchantService.removeMerchant(merchantService.findMerchantById(merchantId));
		} catch (RuntimeException e) {
			resMsg = new ResponseMessage("Merchant Record Not Found", 404, null, null);
			return resMsg;
		}
		resMsg = new ResponseMessage("Merchant Record Deleted", 200, null, null);
		return resMsg;
	}

}
