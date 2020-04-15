package com.gpn.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;

@RunWith(PowerMockRunner.class)
public class GeneratePhoneNumberServiceImplTest {
	
	@Test
	public void testGeneratePhoneNumbers() {
		
		GeneratePhoneNumberServiceImpl gpnImpl = new GeneratePhoneNumberServiceImpl();
		String inputPhone = "4758551263";
		int page = 0;
		int size = 10;
		int totalGeneratedNumbers = 260;
		Page<String> result = gpnImpl.generatePhoneNumbers(inputPhone, page, size);
		assertNotNull(result);
		assertEquals(size, result.getPageable().getPageSize());
		assertEquals(page, result.getPageable().getPageNumber());
		assertEquals(size, result.getContent().size());
		assertTrue(totalGeneratedNumbers == result.getTotalElements());		
	}

}
