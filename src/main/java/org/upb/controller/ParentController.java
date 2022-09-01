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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upb.dao.IParent;
import org.upb.data.Parent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Parents :"})
@Tag(name = "Parents :",description = "ressource Parents")
public class ParentController {
	
	@Autowired
	private IParent parent;
	
	@ApiOperation(value = "L'URL pour la liste des parents")
	@GetMapping(value = "/parents")
	public List<Parent> getListeParent(){
		return parent.findAll();
	}
	@ApiOperation(value = "L'URL pour enregistrer un parent")
	@PostMapping(value = "/parents")
	public Parent EnregistrerParent(Parent a){
		return parent.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer un parent en fonction de son identifiant")
	@GetMapping(value = "/parents/{id}")
    public Parent getListeParentId(@PathVariable(name = "id") Integer id){
    	return parent.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour la modifier les informations d'un parent")
	@PutMapping(value = "/parents/{id}")
	public Parent updateParent(@PathVariable(name="id") Integer id,@RequestBody Parent p) {
		p.setIdParent(id);
		return parent.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer un parent de la base de donnée")
	@DeleteMapping(value = "/parents/{id}")
	public void supprimerParent(@PathVariable(name="id") Integer id) {
		
	}

}
