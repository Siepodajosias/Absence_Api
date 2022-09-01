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
import org.upb.dao.IEnseignant;
import org.upb.dao.IEtudiant;
import org.upb.dao.IParent;
import org.upb.dao.IRole2;
import org.upb.dao.IUtilisateur;
import org.upb.data.Administrateur;
import org.upb.data.Enseignant;
import org.upb.data.Etudiant;
import org.upb.data.Parent;
import org.upb.data.Utilisateur;
import org.upb.data.Utilisateur2;
import org.upb.service.AccountSservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Utilisateurs :"})
@Tag(name = "Utilisateurs :",description = "ressources Utilisateurs")
public class UtilisateurController {
	
	@Autowired
	private AccountSservice accountservice;
	
	@Autowired
	private IUtilisateur utilisateur;
	@Autowired
	private IRole2 role;
	@Autowired
	private IAdministrateur administrateur;
	@Autowired
	private IEtudiant etudiant;
	@Autowired
	private IEnseignant enseignant;
	@Autowired
	private IParent parent;
	
	@ApiOperation(value = "L'URL pour la liste des utilisateurs")
	@GetMapping(value = "/utilisateurs")
	public List<Utilisateur> getListeAbsence(){
		return utilisateur.findAll();
	}
	
	@ApiOperation(value = "L'URL pour inscrire un utilisateur. Utiliser les champs de l'entité utilisateur2 pour l'implémentation de votre application")
	@PostMapping(value = "/inscriptions")
	public Utilisateur EnregistrerUtilisateur(@RequestBody Utilisateur2 a){
		   Utilisateur utilisateur1=new Utilisateur();
		   utilisateur1.setNom(a.getNom());
		   utilisateur1.setPrenom(a.getPrenom());
		   utilisateur1.setNumero(a.getNumero());
		   utilisateur1.setLogin(a.getLogin());
		   utilisateur1.setPasswordUtilisateur(a.getPasswordUtilisateur());
		   utilisateur1.setRoles(role.findBylibelleRole(a.getRoles()));
		return accountservice.saveUtilisateur(utilisateur1);
	}

	@GetMapping(value = "/utilisateurs/{id}")
    public Utilisateur getListeUtilisateurId(@PathVariable(name = "id") Integer id){
    	return utilisateur.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier le profile d'un utilisateur. Utiliser les champs de le modèle utilisateur2 pour l'implémentation de votre application")
	@PutMapping(value = "/profile/{id}")
	public Utilisateur updateUtilisateur(@PathVariable(name="id") Integer id,@RequestBody Utilisateur2 a) {
		
		   Administrateur administrateur1=new Administrateur();
		   Enseignant enseignant1=new Enseignant();
		   Etudiant etudiant1=new Etudiant();
		   Parent parent1=new Parent();
		   Utilisateur utilisateur1=new Utilisateur();
		   
		   administrateur1=administrateur.findByidResponsable(a.getAdministrateur());
		   enseignant1=enseignant.findByidEnseignant(a.getEnseignant());
		   etudiant1=etudiant.findBymatriculeEtudiant(a.getEtudiant());
		   parent1=parent.findByidParent(a.getParent());
		   
		   utilisateur1.setNom(a.getNom());
		   utilisateur1.setPrenom(a.getPrenom());
		   utilisateur1.setNumero(a.getNumero());
		   utilisateur1.setLogin(a.getLogin());
		   utilisateur1.setPasswordUtilisateur(a.getPasswordUtilisateur());
		   utilisateur1.setAdministrateur(administrateur1);
		   utilisateur1.setEnseignant(enseignant1);
		   utilisateur1.setEtudiant(etudiant1);
		   utilisateur1.setParent(parent1);
		   utilisateur1.setRoles(role.findBylibelleRole(a.getRoles()));
		   utilisateur1.setIdUtilisateur(id);
		return accountservice.saveUtilisateur(utilisateur1);
	}

	@ApiOperation(value = "L'URL pour retirer un utilisateur de la base de donnée")
	@DeleteMapping(value = "/utilisateurs/{id}")
	public void supprimerUtilisateur(@PathVariable(name="id") Integer id) {
		
	}
	

}
