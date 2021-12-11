package com.ba.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("UserAccessService")
public class UserAccessService {

	public boolean hasAuthority(String role, String name) {
		// call to 3rd party service and validate with role
		List<String> list = Arrays.asList("CUSTOM-ROLE-1", "CUSTOM-ROLE-2", "CUSTOM-ROLE-3");
		if (name.endsWith("a")) {
			return false;
		}
		return list.contains(role);
	}
}
