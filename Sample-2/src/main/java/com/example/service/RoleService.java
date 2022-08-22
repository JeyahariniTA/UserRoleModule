package com.example.service;

import java.util.List;

import com.example.model.Role;

public interface RoleService {

	public List<Role> listRoles();

	public Role addRole(Role roleDto);

	public List<Role> getRoleByName(String roleName);

	public Role updateRole(Role roleDto);

	public String deleteRole(int id);

}
