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
import org.upb.dao.INiveau;
import org.upb.data.Niveau;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Niveau :"})
@Tag(name = "Niveau :",description = "ressource Niveau")
public class NiveauController {

	  @Autowired
	  private INiveau niveau;
	  
	  @ApiOperation(value = "L'URL pour la liste des niveux")
		@GetMapping(value = "/niveaux")
		public List<Niveau> getListeNiveau(){
			return niveau.findAll();
		}
	  @ApiOperation(value = "L'URL pour enregistrer un niveau")
		@PostMapping(value = "/niveaux")
		public Niveau EnregistrerUe(@RequestBody Niveau a){
			return niveau.save(a);
		}
		
	  @ApiOperation(value = "L'URL pour récuperer un niveau en fonction de son identifiant")
		@GetMapping(value = "/niveaux/{id}")
	    public Niveau getListeNiveauId(@PathVariable(name = "id") Integer id){
	    	return niveau.findById(id).get();
	    }
		  
	  @ApiOperation(value = "L'URL pour modifier les informations d'un niveau")
		@PutMapping(value = "/niveaux/{id}")
		public Niveau updateNiveau(@PathVariable(name="id") Integer id,@RequestBody Niveau p) {
			p.setIdNiveau(id);
			return niveau.save(p);
		}
	  @ApiOperation(value = "L'URL pour retirer un niveau de la base de donnée")
		@DeleteMapping(value = "/niveaux/{id}")
		public void supprimerNiveau(@PathVariable(name="id") Integer id) {
			
		}
}
