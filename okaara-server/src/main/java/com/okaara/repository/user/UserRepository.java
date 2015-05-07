package com.okaara.repository.user;

import com.okaara.shared.client.model.User;

public interface UserRepository {

	User get(int id);

	void save(User user);
}
