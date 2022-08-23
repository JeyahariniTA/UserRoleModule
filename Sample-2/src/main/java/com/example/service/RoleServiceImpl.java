package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.RoleMapper;
import com.example.model.Role;
import com.example.model.RoleDto;
import com.example.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<RoleDto> listRoles() {
		return roleMapper.convertRoleToDto(roleRepository.findAll());
	}

	@Override
	public RoleDto addRole(Role role) {
		return roleMapper.convertRoleToDto(roleRepository.save(role));
	}

	@Override
	public List<RoleDto> getRoleByName(String roleName) {
		return roleMapper.convertRoleToDto(roleRepository.findByRole(roleName));
	}

	@Override
	public RoleDto updateRole(Role role) {
		if (roleRepository.existsById(role.getId())) {
//			roleRepository.
			return roleMapper.convertRoleToDto(roleRepository.save(role));
		} else {
			return new RoleDto();
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

	@Override
	public RoleDto findRoleByUserId(int userId) {
		return roleMapper.convertRoleToDto(roleRepository.findByUsers_Id(userId)); // Role
//		role = roleRepository.getReferenceById(userId); //
//		System.out.println(roleMapper.convertRoleToDto(role)); // return new
//		RoleDto();
	}

}
