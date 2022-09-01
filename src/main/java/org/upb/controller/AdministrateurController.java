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
import org.upb.dao.IAdministrateur;
import org.upb.data.Administrateur;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Administrateurs :"})
@Tag(name = "Administrateurs :",description = "ressources administrateurs")
public class AdministrateurController {
	@Autowired
 private IAdministrateur administrateur;
 
	@ApiOperation(value = "L'URL pour la liste des administratieurs")
	@GetMapping(value = "/administrateurs")
	public List<Administrateur> getListeAdministrateur(){
		return administrateur.findAll();
	}
	@ApiOperation(value = "L'URL pour enregistrer un administrateur")
	@PostMapping(value = "/administrateurs")
	public Administrateur EnregistrerAdministrateur(Administrateur a){
		return administrateur.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer un administrateur en fonction de son identifiant")
	@GetMapping(value = "/administrateurs/{id}")
    public Administrateur getListeAdministrateurId(@PathVariable(name = "id") Integer id){
    	return administrateur.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'un administrateur")
	@PutMapping(value = "/administrateurs/{id}")
	public Administrateur updateAdministrateur(@PathVariable(name="id") Integer id,@RequestBody Administrateur p) {
		p.setIdResponsable(id);
		return administrateur.save(p);
	}

	@ApiOperation(value = "L'URL pour rétirer un adminstrateur de la base de donnée")
	@DeleteMapping(value = "/administrateurs/{id}")
	public void supprimerAdministrateur(@PathVariable(name="id") Integer id) {
		
	}
}
