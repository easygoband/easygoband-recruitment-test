package com.assignment.easygoband.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.easygoband.helper.EasyGoBandFilter;
import com.assignment.easygoband.service.IEasyGoBandService;

@RestController
public class EasyGoBandController {

	@Autowired
	IEasyGoBandService service;
	
	@GetMapping("/providers/{eventId}")
	public List<Map<String, Object>> provider(@PathVariable String eventId, @RequestParam Map<String,String> allParams){
		return EasyGoBandFilter.filterByParam(service.getProviders(eventId),allParams);
	}
	
}
