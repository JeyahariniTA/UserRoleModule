package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public static void update(User userDto, int id) {

	}

}
