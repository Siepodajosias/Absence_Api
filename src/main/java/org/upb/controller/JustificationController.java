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
import org.upb.dao.IJustification;
import org.upb.data.Justification;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Justifications :"})
@Tag(name = "Justifications :",description = "ressources Justifications")
public class JustificationController {
	@Autowired
   private IJustification justification;
	
	
	@ApiOperation(value = "L'URL pour la liste des justifications")
	@GetMapping(value = "/justifications")
	public List<Justification> getListeJustification(){
		return justification.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer une justification")
	@PostMapping(value = "/justifications")
	public Justification EnregistrerJustification(Justification a){
		return justification.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer une justification en fonction de son identifiant")
	@GetMapping(value = "/justifications/{id}")
    public Justification getListeJustificationId(@PathVariable(name = "id") Integer id){
    	return justification.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'une justification")
	@PutMapping(value = "/justifications/{id}")
	public Justification updateJustification(@PathVariable(name="id") Integer id,@RequestBody Justification p) {
		p.setIdJustification(id);
		return justification.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer une justification de la base de donnée")
	@DeleteMapping(value = "/justifications/{id}")
	public void supprimerJustification(@PathVariable(name="id") Integer id) {
		
	}
}
