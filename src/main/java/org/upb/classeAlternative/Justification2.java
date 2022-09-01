package org.upb.classeAlternative;

import java.util.Date;

public class Justification2 {
	
	private Integer idJustification;
	private Integer absence;
	private Date dateJustification;
	private String motifJustification;
	private String commentaireJustification;
	private String fichierJustification;
	private Byte validerJustification;

	public Justification2() {
	}

	public Justification2(Integer absence, Date dateJustification, String motifJustification) {
		this.absence = absence;
		this.dateJustification = dateJustification;
		this.motifJustification = motifJustification;
	}

	public Justification2(Integer absence, Date dateJustification, String motifJustification,
			String commentaireJustification, String fichierJustification, Byte validerJustification) {
		this.absence = absence;
		this.dateJustification = dateJustification;
		this.motifJustification = motifJustification;
		this.commentaireJustification = commentaireJustification;
		this.fichierJustification = fichierJustification;
		this.validerJustification = validerJustification;
	}


	public Integer getIdJustification() {
		return this.idJustification;
	}

	public void setIdJustification(Integer idJustification) {
		this.idJustification = idJustification;
	}

	public Integer getAbsence() {
		return this.absence;
	}

	public void setAbsence(Integer absence) {
		this.absence = absence;
	}

	public Date getDateJustification() {
		return this.dateJustification;
	}

	public void setDateJustification(Date dateJustification) {
		this.dateJustification = dateJustification;
	}

	public String getMotifJustification() {
		return this.motifJustification;
	}

	public void setMotifJustification(String motifJustification) {
		this.motifJustification = motifJustification;
	}

	public String getCommentaireJustification() {
		return this.commentaireJustification;
	}

	public void setCommentaireJustification(String commentaireJustification) {
		this.commentaireJustification = commentaireJustification;
	}


	public String getFichierJustification() {
		return this.fichierJustification;
	}

	public void setFichierJustification(String fichierJustification) {
		this.fichierJustification = fichierJustification;
	}


	public Byte getValiderJustification() {
		return this.validerJustification;
	}

	public void setValiderJustification(Byte validerJustification) {
		this.validerJustification = validerJustification;
	}
}
