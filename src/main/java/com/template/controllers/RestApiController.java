package com.template.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.template.dto.UserDto;
import com.template.services.ITemplateService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	/**
	 * Service provider for "template" queries.
	 */
	private ITemplateService templateService;
	
	/**
	 * Constructs a new RestApiController with the given service 
	 * provider.
	 * 
	 * @param templateService The "template" service provider.
	 */
	@Autowired
	public RestApiController(ITemplateService templateService) {
		this.templateService = templateService;
	}
	
	@RequestMapping(value = "listUsers",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> listUsers() {
		return templateService.getAllUsers();
	}
}
