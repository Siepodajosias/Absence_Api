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
import org.upb.dao.IEnseignant;
import org.upb.data.Enseignant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Enseignants :"})
@Tag(name = "Enseignants :",description = "ressources Enseignants")
public class EnseignantController {

	@Autowired
	private IEnseignant enseignant;
	
	@ApiOperation(value = "L'URL pour la liste des enseignants")
		@GetMapping(value = "/enseignants")
		public List<Enseignant> getListeEnseignant(){
			return enseignant.findAll();
		}
	@ApiOperation(value = "L'URL pour enregistrer un enseignant")
		@PostMapping(value = "/enseignants")
		public Enseignant EnregistrerEnseignant(Enseignant a){
			return enseignant.save(a);
		}
		
	@ApiOperation(value = "L'URL pour récuperer un enseignant en fonction de son identifiant")
		@GetMapping(value = "/enseignants/{id}")
	    public Enseignant getListeEnseignantId(@PathVariable(name = "id") Integer id){
	    	return enseignant.findById(id).get();
	    }
	
	@ApiOperation(value = "L'URL pour modifier les informations d'un enseignant")
		@PutMapping(value = "/enseignants/{id}")
		public Enseignant updateEnseignant(@PathVariable(name="id") Integer id,@RequestBody Enseignant p) {
			p.setIdEnseignant(id);
			return enseignant.save(p);
		}

	@ApiOperation(value = "L'URL pour retirer un enseignant de la base de donnée")
		@DeleteMapping(value = "/enseignants/{id}")
		public void supprimerEnseignant(@PathVariable(name="id") Integer id) {
			
		}
}
