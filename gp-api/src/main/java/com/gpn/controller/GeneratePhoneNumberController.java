package com.gpn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpn.service.GeneratePhoneNumberService;
import com.gpn.vo.PhoneNmnrRqst;
/**
 * @author Muthu Raja
 * This controller class receives the request and 
 * returns generated phone numbers with Pagination.
 *
 */
@RestController
@RequestMapping("/")
public class GeneratePhoneNumberController {

	@Autowired
	GeneratePhoneNumberService gpnSvc;

	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<Object> generatePhoneNumbers(@RequestBody PhoneNmnrRqst pnrq) {

		String phoneNmbr = pnrq.getPhoneNumber();
		int page = pnrq.getPage();
		int size = pnrq.getSize();
		Page<String> result = gpnSvc.generatePhoneNumbers(phoneNmbr, page, size);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
