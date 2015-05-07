package com.okaara.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaara.repository.user.UserRepository;
import com.okaara.shared.client.model.User;

@Service
public class UserBusiness {

	@Autowired
	private UserRepository repository;

	public User get(int id) {
		return repository.get(id);
	}

	public void save(User user) {
		repository.save(user);
	}

}
