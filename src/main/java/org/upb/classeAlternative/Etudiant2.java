package org.upb.classeAlternative;

import java.util.Date;

public class Etudiant2 {
	
	private String matriculeEtudiant;
	private String filiere;
	private String niveau;
	private Date dateNaissanceEtudiant;
	private String genreEtudiant;
	private String residenceEtudiant;


	public Etudiant2() {
	}


	public Etudiant2(String matriculeEtudiant, String filiere, String niveau, Date dateNaissanceEtudiant,
			String genreEtudiant, String residenceEtudiant) {
		super();
		this.matriculeEtudiant = matriculeEtudiant;
		this.filiere = filiere;
		this.niveau = niveau;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.genreEtudiant = genreEtudiant;
		this.residenceEtudiant = residenceEtudiant;
	}






	public String getMatriculeEtudiant() {
		return this.matriculeEtudiant;
	}

	public void setMatriculeEtudiant(String matriculeEtudiant) {
		this.matriculeEtudiant = matriculeEtudiant;
	}

	public String getFiliere() {
		return this.filiere;
	}

	public void setIdFiliere(String id) {
		this.filiere = id;
	}


	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String id) {
		this.niveau = id;
	}


	public Date getDateNaissanceEtudiant() {
		return this.dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	public String getGenreEtudiant() {
		return this.genreEtudiant;
	}

	public void setGenreEtudiant(String genreEtudiant) {
		this.genreEtudiant = genreEtudiant;
	}


	public String getResidenceEtudiant() {
		return this.residenceEtudiant;
	}

	public void setResidenceEtudiant(String residenceEtudiant) {
		this.residenceEtudiant = residenceEtudiant;
	}

}
