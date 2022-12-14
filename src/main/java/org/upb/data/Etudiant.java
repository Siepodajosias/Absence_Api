package org.upb.data;
// Generated 31 ao�t 2022 � 12:53:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Etudiant generated by hbm2java
 */
@Entity
@Table(name = "etudiant", catalog = "heroku_88ae11bd39df693")
public class Etudiant implements java.io.Serializable {

	private String matriculeEtudiant;
	private Filiere filiere;
	private Niveau niveau;
	private Date dateNaissanceEtudiant;
	private String genreEtudiant;
	private String residenceEtudiant;
	private Set<Parent> parents = new HashSet<Parent>(0);
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);
	private Set<Absence> absences = new HashSet<Absence>(0);

	public Etudiant() {
	}

	public Etudiant(String matriculeEtudiant, Filiere filiere, Niveau niveau, Date dateNaissanceEtudiant,
			String genreEtudiant, String residenceEtudiant) {
		this.matriculeEtudiant = matriculeEtudiant;
		this.filiere = filiere;
		this.niveau = niveau;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.genreEtudiant = genreEtudiant;
		this.residenceEtudiant = residenceEtudiant;
	}

	public Etudiant(String matriculeEtudiant, Filiere filiere, Niveau niveau, Date dateNaissanceEtudiant,
			String genreEtudiant, String residenceEtudiant, Set<Parent> parents, Set<Utilisateur> utilisateurs,
			Set<Absence> absences) {
		this.matriculeEtudiant = matriculeEtudiant;
		this.filiere = filiere;
		this.niveau = niveau;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.genreEtudiant = genreEtudiant;
		this.residenceEtudiant = residenceEtudiant;
		this.parents = parents;
		this.utilisateurs = utilisateurs;
		this.absences = absences;
	}

	@Id

	@Column(name = "matricule_etudiant", unique = true, nullable = false, length = 30)
	public String getMatriculeEtudiant() {
		return this.matriculeEtudiant;
	}

	public void setMatriculeEtudiant(String matriculeEtudiant) {
		this.matriculeEtudiant = matriculeEtudiant;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Filiere_id_filiere", nullable = false)
	public Filiere getFiliere() {
		return this.filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Niveau_id_niveau", nullable = false)
	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance_etudiant", nullable = false, length = 10)
	public Date getDateNaissanceEtudiant() {
		return this.dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	@Column(name = "genre_etudiant", nullable = false, length = 45)
	public String getGenreEtudiant() {
		return this.genreEtudiant;
	}

	public void setGenreEtudiant(String genreEtudiant) {
		this.genreEtudiant = genreEtudiant;
	}

	@Column(name = "residence_etudiant", nullable = false, length = 45)
	public String getResidenceEtudiant() {
		return this.residenceEtudiant;
	}

	public void setResidenceEtudiant(String residenceEtudiant) {
		this.residenceEtudiant = residenceEtudiant;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "etudiant_has_parent", catalog = "heroku_88ae11bd39df693", joinColumns = {
			@JoinColumn(name = "Etudiant_matricule_etudiant", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Parent_id_parent", nullable = false, updatable = false) })
	public Set<Parent> getParents() {
		return this.parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "etudiant")
	public Set<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "etudiant")
	public Set<Absence> getAbsences() {
		return this.absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

}
