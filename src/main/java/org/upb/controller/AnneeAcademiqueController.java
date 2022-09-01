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
import org.upb.dao.IAnneeAcademique;
import org.upb.data.AnneeAcademique;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Annee Academique :"})
@Tag(name = "Annee Academique :",description = "ressource Année Academique")
public class AnneeAcademiqueController {

	@Autowired
	private IAnneeAcademique anneeAcademique;
	
	@ApiOperation(value = "L'URL pour la liste des années académiques")
	@GetMapping(value = "/anneeAcademiques")
	public List<AnneeAcademique> getListeAnneeAcademique(){
		return anneeAcademique.findAll();
	}
	@PostMapping(value = "/anneeAcademiques")
	public AnneeAcademique EnregistrerAnneeAcademique(@RequestBody AnneeAcademique a){
		return anneeAcademique.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer une année académique en fonction de son identifiant")
	@GetMapping(value = "/anneeAcademiques/{id}")
    public AnneeAcademique getListeAnneeAcademiqueId(@PathVariable(name = "id") Integer id){
    	return anneeAcademique.findById(id).get();
    }
	@ApiOperation(value = "L'URL pour modifier les informations d'une année académique")
	@PutMapping(value = "/anneeAcademiques/{id}")
	public AnneeAcademique updateAnneeAcademique(@PathVariable(name="id") Integer id,@RequestBody AnneeAcademique p) {
		p.setIdAnneeAcademique(id);
		return anneeAcademique.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer une année académique de la base de donnée")
	@DeleteMapping(value = "/anneeAcademiques/{id}")
	public void supprimerAnneeAcademique(@PathVariable(name="id") Integer id) {
		
	}
}
