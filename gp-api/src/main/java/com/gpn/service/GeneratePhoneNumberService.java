package com.gpn.service;

import org.springframework.data.domain.Page;

public interface GeneratePhoneNumberService {

	public Page<String> generatePhoneNumbers(String phoneNmbr, int page, int size);

}
