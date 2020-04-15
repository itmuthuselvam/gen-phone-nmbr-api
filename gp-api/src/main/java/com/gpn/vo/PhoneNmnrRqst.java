package com.gpn.vo;

import lombok.Data;

@Data
public class PhoneNmnrRqst {
	private String phoneNumber;
	private Integer page = 0;
	private Integer size = 10;
}
