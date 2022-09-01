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
import org.upb.dao.IEcue;
import org.upb.data.Ecue;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Ecue :"})
@Tag(name = "Ecue :",description = "ressource ECUE")
public class EcueController {
	
	@Autowired
	private IEcue ue;
	
	@ApiOperation(value = "L'URL pour la liste des ecue")
	@GetMapping(value = "/ecues")
	public List<Ecue> getListeUe(){
		return ue.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer un ecue")
	@PostMapping(value = "/ecues")
	public Ecue EnregistrerUe(@RequestBody Ecue a){
		return ue.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer un ecue en fonction de son identifiant")
	@GetMapping(value = "/ecues/{id}")
    public Ecue getListeUeId(@PathVariable(name = "id") Integer id){
    	return ue.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'un ecue")
	@PutMapping(value = "/ecues/{id}")
	public Ecue updateUe(@PathVariable(name="id") Integer id,@RequestBody Ecue p) {
		p.setIdEcue(id);
		return ue.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer un ecue de la base de donnée")
	@DeleteMapping(value = "/ecues/{id}")
	public void supprimerUe(@PathVariable(name="id") Integer id) {
		
	}

}
