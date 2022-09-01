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
import org.upb.dao.IFiliere;
import org.upb.data.Filiere;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Filieres :"})
@Tag(name = "Filieres :",description = "ressources Filières")
public class FiliereController {
	
	@Autowired
	private IFiliere filiere;
	
	@ApiOperation(value = "L'URL pour la liste des filières")
	@GetMapping(value = "/filieres")
	public List<Filiere> getListeFiliere(){
		return filiere.findAll();
	}
	@ApiOperation(value = "L'URL pour enregistrer une filière")
	@PostMapping(value = "/filieres")
	public Filiere EnregistrerFiliere(Filiere a){
		return filiere.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer une filières en fonction de son identifiant")
	@GetMapping(value = "/filieres/{id}")
    public Filiere getListeFiliereId(@PathVariable(name = "id") Integer id){
    	return filiere.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'une filière")
	@PutMapping(value = "/filieres/{id}")
	public Filiere updateFiliere(@PathVariable(name="id") Integer id,@RequestBody Filiere p) {
		p.setIdFiliere(id);
		return filiere.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer une filière de la base de donnée")
	@DeleteMapping(value = "/filieres/{id}")
	public void supprimerFiliere(@PathVariable(name="id") Integer id) {
		
	}

}
