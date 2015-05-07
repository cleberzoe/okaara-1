package com.okaara.framework.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dao {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dao.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private String getSql(String file, Model params) {
		return SqlTemplateUtils.parseFile(getClass(), file, params);
	}

	protected <T> T findOne(String filename, Model params, RowMapper<T> mapper) {
		try {
			return jdbcTemplate.query(getSql(filename, params), params, new ResultSetExtractor<T>() {
				@Override
				public T extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						return mapper.mapRow(rs, rs.getRow());
					}
					return null;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			LOGGER.warn("Não foi encontrado nada para os parâmetros", e);
			return null;
		} catch (Throwable e) {
			LOGGER.error("Erro ao tentar consultar o objeto no banco de dado", e);
			throw new RuntimeException(e);
		}
	}

	protected <T> void update(String filename, Model params) {
		String sql = getSql(filename, params);
		LOGGER.debug("Update {} {}", sql, params);
		jdbcTemplate.update(sql, params);
	}

}
