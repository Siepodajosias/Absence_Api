package org.upb.data;
// Generated 31 ao�t 2022 � 12:53:26 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Parent generated by hbm2java
 */
@Entity
@Table(name = "parent", catalog = "upb")
public class Parent implements java.io.Serializable {

	private Integer idParent;
	private String residenceParent;
	private Set<Utilisateur> utilisateurs = new HashSet<Utilisateur>(0);
	private Set<Etudiant> etudiants = new HashSet<Etudiant>(0);

	public Parent() {
	}

	public Parent(String residenceParent) {
		this.residenceParent = residenceParent;
	}

	public Parent(String residenceParent, Set<Utilisateur> utilisateurs, Set<Etudiant> etudiants) {
		this.residenceParent = residenceParent;
		this.utilisateurs = utilisateurs;
		this.etudiants = etudiants;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id_parent", unique = true, nullable = false)
	public Integer getIdParent() {
		return this.idParent;
	}

	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}

	@Column(name = "residence_parent", nullable = false, length = 45)
	public String getResidenceParent() {
		return this.residenceParent;
	}

	public void setResidenceParent(String residenceParent) {
		this.residenceParent = residenceParent;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	public Set<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "etudiant_has_parent", catalog = "upb", joinColumns = {
			@JoinColumn(name = "Parent_id_parent", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Etudiant_matricule_etudiant", nullable = false, updatable = false) })
	public Set<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}