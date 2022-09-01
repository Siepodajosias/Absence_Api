package org.upb.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.upb.classeAlternative.Ecue2;
import org.upb.dao.IEcue;
import org.upb.dao.ISemestre;
import org.upb.data.Ecue;
import org.upb.data.Semestre;

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
	
	@Autowired
	private ISemestre semestre;
	
	@ApiOperation(value = "L'URL pour la liste des ecue")
	@GetMapping(value = "/ecues")
	public List<Ecue> getListeUe(){
		return ue.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer un ecue.Utiliser les champs du modèle ecue2 pour l'implémentation de votre application")
	@PostMapping(value = "/ecues")
	public Ecue EnregistrerEcue(@RequestBody Ecue2 a){
		Ecue ecue1=new Ecue();
		
		Set<Semestre> semestres = new HashSet<Semestre>(0);
		semestres.add(semestre.findByidSemestre(a.getSemestres()));
		
		ecue1.setLibelleEcue(a.getLibelleEcue());
		ecue1.setTypeCours(a.getTypeCours());
		ecue1.setSemestres(semestres);
		
		return ue.save(ecue1);
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
