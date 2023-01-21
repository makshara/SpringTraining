package com.spring.training.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.training.models.User;

@Repository
public class JdbcUserRepository implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject(
				"select count(*) from a_user_table", Integer.class);
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(
				"select * from a_user_table",
				(rs, rowNum)-> new User(
						rs.getString("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name")
						)
				);
	}	
 
}
