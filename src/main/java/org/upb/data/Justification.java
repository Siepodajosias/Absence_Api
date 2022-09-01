package org.upb.data;
// Generated 31 ao�t 2022 � 12:53:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Justification generated by hbm2java
 */
@Entity
@Table(name = "justification", catalog = "heroku_88ae11bd39df693")
public class Justification implements java.io.Serializable {

	private Integer idJustification;
	private Absence absence;
	private Date dateJustification;
	private String motifJustification;
	private String commentaireJustification;
	private String fichierJustification;
	private Byte validerJustification;

	public Justification() {
	}

	public Justification(Absence absence, Date dateJustification, String motifJustification) {
		this.absence = absence;
		this.dateJustification = dateJustification;
		this.motifJustification = motifJustification;
	}

	public Justification(Absence absence, Date dateJustification, String motifJustification,
			String commentaireJustification, String fichierJustification, Byte validerJustification) {
		this.absence = absence;
		this.dateJustification = dateJustification;
		this.motifJustification = motifJustification;
		this.commentaireJustification = commentaireJustification;
		this.fichierJustification = fichierJustification;
		this.validerJustification = validerJustification;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id_justification", unique = true, nullable = false)
	public Integer getIdJustification() {
		return this.idJustification;
	}

	public void setIdJustification(Integer idJustification) {
		this.idJustification = idJustification;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Absence_id_absence", nullable = false)
	public Absence getAbsence() {
		return this.absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_justification", nullable = false, length = 10)
	public Date getDateJustification() {
		return this.dateJustification;
	}

	public void setDateJustification(Date dateJustification) {
		this.dateJustification = dateJustification;
	}

	@Column(name = "motif_justification", nullable = false, length = 45)
	public String getMotifJustification() {
		return this.motifJustification;
	}

	public void setMotifJustification(String motifJustification) {
		this.motifJustification = motifJustification;
	}

	@Column(name = "commentaire_justification")
	public String getCommentaireJustification() {
		return this.commentaireJustification;
	}

	public void setCommentaireJustification(String commentaireJustification) {
		this.commentaireJustification = commentaireJustification;
	}

	@Column(name = "fichier_justification", length = 45)
	public String getFichierJustification() {
		return this.fichierJustification;
	}

	public void setFichierJustification(String fichierJustification) {
		this.fichierJustification = fichierJustification;
	}

	@Column(name = "valider_justification")
	public Byte getValiderJustification() {
		return this.validerJustification;
	}

	public void setValiderJustification(Byte validerJustification) {
		this.validerJustification = validerJustification;
	}

}
