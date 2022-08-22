package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public List<Role> findByRole(String roleName);

}
