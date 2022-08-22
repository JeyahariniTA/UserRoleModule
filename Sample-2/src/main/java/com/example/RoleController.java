package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Role;
import com.example.service.RoleService;

@RestController
@RequestMapping(path = "/role")
public class RoleController {

	@Autowired
	RoleService dao;

	@GetMapping(path = "/get")
	public List<Role> listRoles() {
		return dao.listRoles();
	}

	@GetMapping(path = "/get/{roleName}")
	public List<Role> getRolesByName(@PathVariable("roleName") String roleName) {
		return dao.getRoleByName(roleName);
	}

	@PostMapping(path = "/add")
	public Role addRole(@RequestBody Role roleDto) {
		return dao.addRole(roleDto);
	}

	@PutMapping(path = "/update")
	public Role updateRole(@RequestBody Role roleDto) {
		return dao.updateRole(roleDto);
	}

	@DeleteMapping(path = "/delete/{roleId}")
	public String deleteRole(@PathVariable("roleId") int id) {
		return dao.deleteRole(id);
	}

}
