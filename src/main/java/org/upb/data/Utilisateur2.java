package org.upb.data;

public class Utilisateur2 {

	private int administrateurId;
	private int enseignantId;
	private int etudiantId;
	private int parentId;
	private String nom;
	private String prenom;
	private String numero;
	private String login;
	private String passwordUtilisateur;
	private String roles;

	public Utilisateur2() {
	}

	public Utilisateur2(String login, String passwordUtilisateur) {
		this.login = login;
		this.passwordUtilisateur = passwordUtilisateur;
	}



	public Utilisateur2(int administrateurId, int enseignantId, int etudiantId, int parentId, String nom, String prenom,
			String numero, String login, String passwordUtilisateur, String roles) {
		super();
		this.administrateurId = administrateurId;
		this.enseignantId = enseignantId;
		this.etudiantId = etudiantId;
		this.parentId = parentId;
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.login = login;
		this.passwordUtilisateur = passwordUtilisateur;
		this.roles = roles;
	}

	public int getAdministrateur() {
		return this.administrateurId;
	}

	public void setAdministrateur(int administrateur) {
		this.administrateurId = administrateur;
	}


	public int getEnseignant() {
		return this.enseignantId;
	}

	public void setEnseignant(int enseignant) {
		this.enseignantId = enseignant;
	}

	public int getEtudiant() {
		return this.etudiantId;
	}

	public void setEtudiant(int etudiant) {
		this.etudiantId = etudiant;
	}

	public int getParent() {
		return this.parentId;
	}

	public void setParent(int parent) {
		this.parentId = parent;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordUtilisateur() {
		return this.passwordUtilisateur;
	}

	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


}
