package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> listRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role addRole(Role roleDto) {
		return roleRepository.save(roleDto);
	}

	@Override
	public List<Role> getRoleByName(String roleName) {
		return roleRepository.findByRole(roleName);
	}

	@Override
	public Role updateRole(Role role) {
		if (roleRepository.existsById(role.getId())) {
			return roleRepository.save(role);
		} else {
			return new Role();
		}
	}

	@Override
	public String deleteRole(int id) {
		if (roleRepository.existsById(id)) {
			roleRepository.deleteById(id);
			return "deleted";
		} else {
			return "id not found";
		}
	}

}
