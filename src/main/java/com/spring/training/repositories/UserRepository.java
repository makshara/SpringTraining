package com.spring.training.repositories;

import java.util.List;

import com.spring.training.models.User;

public interface UserRepository {

	int count();
	List<User> findAll();
	public void batchInsert(List<User> users, int batchSize);
}
