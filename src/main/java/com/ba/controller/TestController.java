package com.ba.controller;

import com.ba.service.TestService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "Basic-Authentication")
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("/{name}")
//	@PreAuthorize("@UserAccessService.hasAuthority(@environment.getProperty('app.security.access-right.hello-endpoint'), #name)")
	public String helloMessage(@PathVariable String name) {
		return testService.hello(name);
	}

}
