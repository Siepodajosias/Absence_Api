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
import org.upb.classeAlternative.Absence2;
import org.upb.dao.IAbsence;
import org.upb.dao.IEcue;
import org.upb.dao.IEnseignant;
import org.upb.dao.IEtudiant;
import org.upb.data.Absence;
import org.upb.data.Ecue;
import org.upb.data.Enseignant;
import org.upb.data.Etudiant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Absences :"})
@Tag(name = "Absences :",description = "ressources absences")
public class AbsenceController {
	
	@Autowired
	private IAbsence absence;
	
	@Autowired
	private IEcue ecue;
	
	@Autowired
	private IEtudiant etudiant;
	
	@Autowired
	private IEnseignant enseignant;
	
	@ApiOperation(value = "L'URL pour la liste des absences")
	@GetMapping(value = "/absences")
	public List<Absence> getListeAbsence(){
		return absence.findAll();
	}
	@ApiOperation(value = "L'URL pour enregistrer une absence. Utiliser les champs du modèle absence2 pour l'implémentation de votre application")
	@PostMapping(value = "/absences")
	public Absence EnregistrerAbsence(Absence2 a){
		Ecue ecue2=new Ecue();
		Etudiant etudiant2=new Etudiant();
		Enseignant enseignant2=new Enseignant();
		Absence absence2=new Absence();
		
		enseignant2=enseignant.findByidEnseignant(a.getEnseignant());
		etudiant2=etudiant.findBymatriculeEtudiant(a.getEtudiant());
		ecue2=ecue.findBylibelleEcue(a.getEcue());
		
		absence2.setDateAbsence(a.getDateAbsence());
		absence2.setEcue(ecue2);
		absence2.setEnseignant(enseignant2);
		absence2.setEtudiant(etudiant2);
		absence2.setHeureDebut(a.getHeureDebut());
		absence2.setHeureFin(a.getHeureFin());
		absence2.setEtatAbsence(a.getEtatAbsence());
		absence2.setStatusAbsence(a.getStatusAbsence());
		
		return absence.save(absence2);
	}
	
	@ApiOperation(value = "L'URL pour récuperer une absence en fonction de son identifiant")
	@GetMapping(value = "/absences/{id}")
    public Absence getListeAbsenceId(@PathVariable(name = "id") Integer id){
    	return absence.findById(id).get();
    }

	@ApiOperation(value = "L'URL pour modifier les informations d'une absence. Utiliser les champs du modèle absence2 pour l'implémentation de votre application")
	@PutMapping(value = "/absences/{id}")
	public Absence updateAbsence(@PathVariable(name="id") Integer id,@RequestBody Absence2 a) {
		Ecue ecue2=new Ecue();
		Etudiant etudiant2=new Etudiant();
		Enseignant enseignant2=new Enseignant();
		Absence absence2=new Absence();
		
		enseignant2=enseignant.findByidEnseignant(a.getEnseignant());
		etudiant2=etudiant.findBymatriculeEtudiant(a.getEtudiant());
		ecue2=ecue.findBylibelleEcue(a.getEcue());
		
		absence2.setDateAbsence(a.getDateAbsence());
		absence2.setEcue(ecue2);
		absence2.setEnseignant(enseignant2);
		absence2.setEtudiant(etudiant2);
		absence2.setHeureDebut(a.getHeureDebut());
		absence2.setHeureFin(a.getHeureFin());
		absence2.setEtatAbsence(a.getEtatAbsence());
		absence2.setStatusAbsence(a.getStatusAbsence());
		
		absence2.setIdAbsence(id);
		return absence.save(absence2);
	}

	@ApiOperation(value = "L'URL pour retirer une absence de la base de donnée")
	@DeleteMapping(value = "/absences/{id}")
	public void supprimerAbsence(@PathVariable(name="id") Integer id) {
		
	}

}
