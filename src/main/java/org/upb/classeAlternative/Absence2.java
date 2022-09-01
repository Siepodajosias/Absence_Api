package org.upb.classeAlternative;

import java.util.Date;

public class Absence2 {
  
	private Integer idAbsence;
	private String ecue;
	private int enseignant;
	private String etudiant;
	private byte statusAbsence;
	private byte etatAbsence;
	private Date dateAbsence;
	private String heureDebut;
	private String heureFin;

	public Absence2() {
	}


	public Absence2(Integer idAbsence, String ecue, int enseignant, String etudiant, byte statusAbsence,
			byte etatAbsence, Date dateAbsence, String heureDebut, String heureFin) {
		super();
		this.idAbsence = idAbsence;
		this.ecue = ecue;
		this.enseignant = enseignant;
		this.etudiant = etudiant;
		this.statusAbsence = statusAbsence;
		this.etatAbsence = etatAbsence;
		this.dateAbsence = dateAbsence;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}




	public Integer getIdAbsence() {
		return this.idAbsence;
	}

	public void setIdAbsence(Integer idAbsence) {
		this.idAbsence = idAbsence;
	}


	public String getEcue() {
		return this.ecue;
	}

	public void setEcue(String ecue) {
		this.ecue = ecue;
	}


	public int getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(int enseignant) {
		this.enseignant = enseignant;
	}

	public String getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(String etudiant) {
		this.etudiant = etudiant;
	}

	public byte getStatusAbsence() {
		return this.statusAbsence;
	}

	public void setStatusAbsence(byte statusAbsence) {
		this.statusAbsence = statusAbsence;
	}

	public byte getEtatAbsence() {
		return this.etatAbsence;
	}

	public void setEtatAbsence(byte etatAbsence) {
		this.etatAbsence = etatAbsence;
	}

	public Date getDateAbsence() {
		return this.dateAbsence;
	}

	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	public String getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

}
