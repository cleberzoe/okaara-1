package com.okaara.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {
	
	@Autowired
	private UserRepository repository;

	public Map<String, Object> get(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("Achei ", id);
		map.put("Qualquer coisa ", id + " dsad");
		return map;
	}

}
