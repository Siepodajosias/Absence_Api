package org.upb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.upb.dao.IRole;
import org.upb.data.Role;

@CrossOrigin("*")
@RestController

public class RoleController {

	@Autowired
	private IRole role;
	
	@GetMapping(value = "/roles")
	public List<Role> getListeRole(){
		return role.findAll();
	}
	@PostMapping(value = "/roles")
	public Role EnregistrerRole(Role a){
		return role.save(a);
	}
	
	@GetMapping(value = "/roles/{id}")
    public Role getListeRoleId(@PathVariable(name = "id") Integer id){
    	return role.findById(id).get();
    }
	  
	@PutMapping(value = "/roles/{id}")
	public Role updateRole(@PathVariable(name="id") Integer id,@RequestBody Role p) {
		p.setIdRole(id);
		return role.save(p);
	}

	@DeleteMapping(value = "/roles/{id}")
	public void supprimerRole(@PathVariable(name="id") Integer id) {
		
	}
}
