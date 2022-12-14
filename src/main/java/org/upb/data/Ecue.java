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
 * Ecue generated by hbm2java
 */
@Entity
@Table(name = "ecue", catalog = "heroku_88ae11bd39df693")
public class Ecue implements java.io.Serializable {

	private Integer idEcue;
	private String libelleEcue;
	private String typeCours;
	private Set<Absence> absences = new HashSet<Absence>(0);
	private Set<Semestre> semestres = new HashSet<Semestre>(0);

	public Ecue() {
	}

	public Ecue(String libelleEcue, String typeCours) {
		this.libelleEcue = libelleEcue;
		this.typeCours = typeCours;
	}

	public Ecue(String libelleEcue, String typeCours, Set<Absence> absences, Set<Semestre> semestres) {
		this.libelleEcue = libelleEcue;
		this.typeCours = typeCours;
		this.absences = absences;
		this.semestres = semestres;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id_ecue", unique = true, nullable = false)
	public Integer getIdEcue() {
		return this.idEcue;
	}

	public void setIdEcue(Integer idEcue) {
		this.idEcue = idEcue;
	}

	@Column(name = "libelle_ecue", nullable = false, length = 45)
	public String getLibelleEcue() {
		return this.libelleEcue;
	}

	public void setLibelleEcue(String libelleEcue) {
		this.libelleEcue = libelleEcue;
	}

	@Column(name = "type_cours", nullable = false, length = 45)
	public String getTypeCours() {
		return this.typeCours;
	}

	public void setTypeCours(String typeCours) {
		this.typeCours = typeCours;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ecue")
	public Set<Absence> getAbsences() {
		return this.absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "semestre_has_ecue", catalog = "heroku_88ae11bd39df693", joinColumns = {
			@JoinColumn(name = "ECUE_id_ue", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Semestre_id_semestre", nullable = false, updatable = false) })
	public Set<Semestre> getSemestres() {
		return this.semestres;
	}

	public void setSemestres(Set<Semestre> semestres) {
		this.semestres = semestres;
	}

}
