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
 * Semestre generated by hbm2java
 */
@Entity
@Table(name = "semestre", catalog = "upb")
public class Semestre implements java.io.Serializable {

	private Integer idSemestre;
	private String libelleSemestre;
	private Set<AnneeAcademique> anneeAcademiques = new HashSet<AnneeAcademique>(0);
	private Set<Ecue> ecues = new HashSet<Ecue>(0);

	public Semestre() {
	}

	public Semestre(String libelleSemestre) {
		this.libelleSemestre = libelleSemestre;
	}

	public Semestre(String libelleSemestre, Set<AnneeAcademique> anneeAcademiques, Set<Ecue> ecues) {
		this.libelleSemestre = libelleSemestre;
		this.anneeAcademiques = anneeAcademiques;
		this.ecues = ecues;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id_semestre", unique = true, nullable = false)
	public Integer getIdSemestre() {
		return this.idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}

	@Column(name = "libelle_semestre", nullable = false, length = 45)
	public String getLibelleSemestre() {
		return this.libelleSemestre;
	}

	public void setLibelleSemestre(String libelleSemestre) {
		this.libelleSemestre = libelleSemestre;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "semestre")
	public Set<AnneeAcademique> getAnneeAcademiques() {
		return this.anneeAcademiques;
	}

	public void setAnneeAcademiques(Set<AnneeAcademique> anneeAcademiques) {
		this.anneeAcademiques = anneeAcademiques;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "semestre_has_ecue", catalog = "upb", joinColumns = {
			@JoinColumn(name = "Semestre_id_semestre", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ECUE_id_ue", nullable = false, updatable = false) })
	public Set<Ecue> getEcues() {
		return this.ecues;
	}

	public void setEcues(Set<Ecue> ecues) {
		this.ecues = ecues;
	}

}
