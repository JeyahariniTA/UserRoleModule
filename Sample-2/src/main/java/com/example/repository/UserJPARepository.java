package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Role;
import com.example.model.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

//	List<User> findUserDataRightJoinByRoleId(int roleId);

	List<User> findByRoleId(int id);

	public List<Role> findRoleById(int id);

}
