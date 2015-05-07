package com.okaara.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.okaara.business.UserBusiness;
import com.okaara.shared.client.model.User;

@Controller
@RequestMapping("/formUsuario")
public class FormController {

	@Autowired
	private UserBusiness userBs;

	@ResponseBody
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") String id) {
		return userBs.get(Integer.parseInt(id));
	}

	@ResponseBody
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestBody User user) {
		userBs.save(user);
		return "Usuário cadastro com sucesso";
	}
}
