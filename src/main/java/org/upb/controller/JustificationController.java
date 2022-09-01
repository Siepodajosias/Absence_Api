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
import org.upb.classeAlternative.Justification2;
import org.upb.dao.IAbsence;
import org.upb.dao.IJustification;
import org.upb.data.Absence;
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
	
	@Autowired
	private IAbsence absence;
	
	@ApiOperation(value = "L'URL pour la liste des justifications")
	@GetMapping(value = "/justifications")
	public List<Justification> getListeJustification(){
		return justification.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer une justification. Utiliser les champs du modèle justification2 pour l'implémentation de votre application")
	@PostMapping(value = "/justifications")
	public Justification EnregistrerJustification(Justification2 a){
		Justification justification1=new Justification();
		Absence absence1=new Absence();
		absence1=absence.findByidAbsence(a.getAbsence());
		
		justification1.setAbsence(absence1);
		justification1.setDateJustification(a.getDateJustification());
		justification1.setMotifJustification(a.getMotifJustification());
		justification1.setCommentaireJustification(a.getCommentaireJustification());
		justification1.setFichierJustification(a.getFichierJustification());
		justification1.setValiderJustification(a.getValiderJustification());
		
		return justification.save(justification1);
	}
	
	@ApiOperation(value = "L'URL pour récuperer une justification en fonction de son identifiant")
	@GetMapping(value = "/justifications/{id}")
    public Justification getListeJustificationId(@PathVariable(name = "id") Integer id){
    	return justification.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'une justification.  Utiliser les champs du modèle justification2 pour l'implémentation de votre application")
	@PutMapping(value = "/justifications/{id}")
	public Justification updateJustification(@PathVariable(name="id") Integer id,@RequestBody Justification2 a) {
		Justification justification1=new Justification();
		Absence absence1=new Absence();
		absence1=absence.findByidAbsence(a.getAbsence());
		
		justification1.setAbsence(absence1);
		justification1.setDateJustification(a.getDateJustification());
		justification1.setMotifJustification(a.getMotifJustification());
		justification1.setCommentaireJustification(a.getCommentaireJustification());
		justification1.setFichierJustification(a.getFichierJustification());
		justification1.setValiderJustification(a.getValiderJustification());
		justification1.setIdJustification(id);
		
		return justification.save(justification1);
	}

	@ApiOperation(value = "L'URL pour retirer une justification de la base de donnée")
	@DeleteMapping(value = "/justifications/{id}")
	public void supprimerJustification(@PathVariable(name="id") Integer id) {
		
	}
}
