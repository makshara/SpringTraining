package com.spring.training.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.spring.training.models.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
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

	@Override
    @Transactional
	public void batchInsert(List<User> users, int batchsize) {
		int[][] list = jdbcTemplate.batchUpdate(
				"insert into a_user_table (user_id, first_name, last_name) values(?,?,?)",
				users,
				batchsize,
				new ParameterizedPreparedStatementSetter<User>() {

					@Override
					public void setValues(PreparedStatement ps, User argument) throws SQLException {
						ps.setString(1,argument.getUser_id());
						ps.setString(2,argument.getFirst_name());
						ps.setString(3,argument.getLast_name());

					}
					
		
				});
		System.out.println("List length: "+list.length);
	}	
 
}
