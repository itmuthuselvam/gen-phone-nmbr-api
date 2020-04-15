package com.gpn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gpn.service.GeneratePhoneNumberService;
import com.gpn.service.exception.GeneratePhoneNumbersException;


/**
 * @author Muthu Raja This service implementation class is for generating phone
 *         number with alphabets.
 *
 */
@Service
public class GeneratePhoneNumberServiceImpl implements GeneratePhoneNumberService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gpn.service.GeneratePhoneNumberService#generatePhoneNumbers(java.lang.
	 * String, int, int) This method generate phone numbers with alphabet for the
	 * given phone number input. This method returns Page Object which enables
	 * pagination from server side.
	 */
	@Override
	public Page<String> generatePhoneNumbers(String phoneNmbr, int page, int size) {
		try {
			Pageable paging = PageRequest.of(page, size);

			String alphabet = getAlphabet();
			List<String> phoneNmbrLst = new ArrayList<>();
			for (int i = 0; i < alphabet.length(); i++) {
				for (int j = 0; j < phoneNmbr.length(); j++) {
					phoneNmbrLst.add(replaceChar(phoneNmbr, alphabet.charAt(i), j));
				}
			}
			int start = (int) paging.getOffset();
			int end = (start + paging.getPageSize());
			Page<String> resultList = new PageImpl<>(new ArrayList());
			resultList = new PageImpl<String>(phoneNmbrLst.subList(start, end), paging, phoneNmbrLst.size());
			return resultList;
		} catch (Exception e) {
			String errorMsg = "Exception when Generating phone numbers";
			throw new GeneratePhoneNumbersException("500", errorMsg, e);
		}

	}

	private String getAlphabet() {
		char[] alphabetChar = new char[26];
		for (int i = 0; i < 26; i++) {
			alphabetChar[i] = (char) (97 + i);
		}
		String alphabet = String.valueOf(alphabetChar).toUpperCase();
		return alphabet;
	}

	private String replaceChar(String phoneNbr, char charToRlpc, int index) {
		char[] chars = phoneNbr.toCharArray();
		chars[index] = charToRlpc;
		return String.valueOf(chars);
	}

}
