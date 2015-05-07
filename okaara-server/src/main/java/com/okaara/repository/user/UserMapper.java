package com.okaara.repository.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.okaara.shared.client.model.User;

public class UserMapper implements RowMapper<User> {

	private final static String ID = "idusuario";
	private final static String NOME = "nome";
	private final static String EMAIL = "email";
	private final static String PASSWORD = "senha";

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getInt(ID), rs.getString(EMAIL), rs.getString(NOME), rs.getString(PASSWORD));
	}
}
