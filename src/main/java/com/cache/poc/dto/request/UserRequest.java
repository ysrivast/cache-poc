package com.cache.poc.dto.request;

import lombok.Data;

@Data
public class UserRequest {

	private String name;
	private AddressRequest addressRequest;
	
}
