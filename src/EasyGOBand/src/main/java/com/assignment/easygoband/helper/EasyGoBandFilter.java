package com.assignment.easygoband.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.assignment.easygoband.constants.Constants;


public class EasyGoBandFilter {

	private static Logger logger = LoggerFactory.getLogger(EasyGoBandFilter.class);
	
	public static List<Map<String, Object>> filterByParam(List<Map<String, Object>> providers, Map<String, String> allParams) {
		List<Map<String, Object>> providersFiltered = new ArrayList<>();
		if(null != allParams && allParams.size() > 0) {
			try {
				for(String key : allParams.keySet()) {
					providersFiltered = providers
					.stream()
					.filter(provider -> {
						Optional providerOpt = Optional.ofNullable(provider.get(key));
						if(providerOpt.isPresent()) {
							if(key.equals(Constants.SESSION_ATTRIBUTE)) {
								Optional<Map<String, String>> value = ((List<Map<String, String>>)(providerOpt.get()))
								.stream()
								.filter(session -> {
									return session.get(Constants.NAME_ATTRIBUTE).equals(allParams.get(key));
								})
								.findFirst();
								return value.isPresent();
							}
							else {
								String value = providerOpt.get().toString();
								return value.equals(allParams.get(key));
							}
						}
						else {
							return false;
						}
						
					})
					.collect(Collectors.toList());
					
					break;
				
				}
				
			} catch (Exception e) {
				logger.error("Error while filtering the providers list", e);
			}
			return providersFiltered;
		}
		else {
			return providers;
		}
		
		
	}

}
