package com.assignment.easygoband.service;

import java.util.List;
import java.util.Map;

import com.assignment.easygoband.vo.Provider;

public interface IEasyGoBandService {

	public List<Map<String, Object>> getProviders(String event);
}
