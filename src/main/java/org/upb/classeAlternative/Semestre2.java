package org.upb.classeAlternative;

import javax.persistence.Column;

public class Semestre2 {
	private Integer idSemestre;
	private Integer anneeAcademiqueId;
	private String libelleSemestre;


	public Semestre2() {
	}

	public Semestre2(Integer anneeAcademique, String libelleSemestre) {
		this.anneeAcademiqueId = anneeAcademique;
		this.libelleSemestre = libelleSemestre;
	}


	public Integer getIdSemestre() {
		return this.idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}


	public Integer getAnneeAcademique() {
		return this.anneeAcademiqueId;
	}

	public void setAnneeAcademique(Integer anneeAcademique) {
		this.anneeAcademiqueId = anneeAcademique;
	}

	@Column(name = "libelle_semestre", nullable = false, length = 45)
	public String getLibelleSemestre() {
		return this.libelleSemestre;
	}

	public void setLibelleSemestre(String libelleSemestre) {
		this.libelleSemestre = libelleSemestre;
	}
}
