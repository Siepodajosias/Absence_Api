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
import org.upb.classeAlternative.Etudiant2;
import org.upb.classeAlternative.Etudiant3;
import org.upb.dao.IEtudiant;
import org.upb.dao.IFiliere;
import org.upb.dao.INiveau;
import org.upb.dao.IParent;
import org.upb.data.Etudiant;
import org.upb.data.Filiere;
import org.upb.data.Niveau;
import org.upb.data.Parent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Etudiants :"})
@Tag(name = "Etudiants :",description = "ressources Etudiants")
public class EtudiantController {
    @Autowired
	private IEtudiant etudiant;
    
    @Autowired
    private IFiliere filiere;
    
    @Autowired
    private IParent parent;
    
    @Autowired
    private INiveau niveau;
	
	@ApiOperation(value = "L'URL pour la liste des étudiants")
	@GetMapping(value = "/etudiants")
	public List<Etudiant> getListeEtudiant(){
		return etudiant.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer un étudiant. Utiliser les champs de l'entité etudiant2 pour l'implémentation de votre application")
	@PostMapping(value = "/etudiants")
	public Etudiant EnregistrerEtudiant(Etudiant2 a){
		
		Etudiant etudiant2=new Etudiant();
		
		Filiere filiere2=filiere.findByDesignationFiliere(a.getFiliere());
		Niveau niveau2=niveau.findBylibelleNiveau(a.getNiveau());
		
		etudiant2.setMatriculeEtudiant(a.getMatriculeEtudiant());
		etudiant2.setGenreEtudiant(a.getGenreEtudiant());
		etudiant2.setFiliere(filiere2);
		etudiant2.setNiveau(niveau2);
		etudiant2.setDateNaissanceEtudiant(a.getDateNaissanceEtudiant());
		etudiant2.setResidenceEtudiant(a.getResidenceEtudiant());
		
		return etudiant.save(etudiant2);
	}
	
	
	@ApiOperation(value = "L'URL pour récuperer un étudiant en fonction de son identifiant")
	@GetMapping(value = "/etudiants/{id}")
    public Etudiant getListeEtudiantId(@PathVariable(name = "id") String id){
    	return etudiant.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'un étudiant. Utiliser les champs de l'entité etudiant3 pour l'implémentation de votre application")
	@PutMapping(value = "/etudiants/{id}")
	public Etudiant updateEtudiant(@PathVariable(name="id") String id,@RequestBody Etudiant3 a) {
		Etudiant etudiant2=new Etudiant();
		
		Set<Parent> parents = new HashSet<Parent>(0);
		
		Filiere filiere2=filiere.findByDesignationFiliere(a.getFiliere());
		Niveau  niveau2=niveau.findBylibelleNiveau(a.getNiveau());
		Parent  parent2=parent.findById(a.getIdParent()).get();
		
		parents.add(parent2);
		etudiant2.setMatriculeEtudiant(id);
		etudiant2.setGenreEtudiant(a.getGenreEtudiant());
		etudiant2.setFiliere(filiere2);
		etudiant2.setNiveau(niveau2);
		etudiant2.setParents(parents);
		etudiant2.setDateNaissanceEtudiant(a.getDateNaissanceEtudiant());
		etudiant2.setResidenceEtudiant(a.getResidenceEtudiant());
	
		return etudiant.save(etudiant2);
	}

	
	@ApiOperation(value = "L'URL pour retirer un étudiant de la base de donnée")
	@DeleteMapping(value = "/etudiants/{id}")
	public void supprimerEtudiant(@PathVariable(name="id") Integer id) {
		
	}
}
