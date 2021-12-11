package com.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private UserAccessService userAccessService;
	@Autowired
	private Environment environment;

	@PreAuthorize("@UserAccessService.hasAuthority(@environment.getProperty('app.security.access-right.hello-endpoint'), #name)")
	public String hello(String name) {
		return hello1(name);
	}

	private String hello1(String name) {
		if (!userAccessService.hasAuthority(environment.getProperty("app.security.access-right.hello-endpoint"), name)) {
			throw new AccessDeniedException("access denied");
		}
		return "welcome " + name;
	}
}
