package com.okaara.repository.user;

import org.springframework.stereotype.Repository;

import com.okaara.framework.repository.Dao;
import com.okaara.framework.repository.Model;
import com.okaara.shared.client.model.User;

@Repository
public class UserRepository extends Dao{

	public User get(int id) {
		return findOne("consulta-usuario.sql", Model.create().add("id", id), new UserMapper());
	}

}
