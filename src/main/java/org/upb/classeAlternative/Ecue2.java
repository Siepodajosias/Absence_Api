package org.upb.classeAlternative;

public class Ecue2 {
	
	private Integer idEcue;
	private String libelleEcue;
	private String typeCours;
	private Integer semestres;

	public Ecue2(){
	}

	public Ecue2(String libelleEcue, String typeCours,Integer semestres) {
		this.libelleEcue = libelleEcue;
		this.typeCours = typeCours;
		this.semestres = semestres;
	}


	public Integer getIdEcue() {
		return this.idEcue;
	}

	public void setIdEcue(Integer idEcue) {
		this.idEcue = idEcue;
	}

	public String getLibelleEcue() {
		return this.libelleEcue;
	}

	public void setLibelleEcue(String libelleEcue) {
		this.libelleEcue = libelleEcue;
	}

	public String getTypeCours() {
		return this.typeCours;
	}

	public void setTypeCours(String typeCours) {
		this.typeCours = typeCours;
	}

	public Integer getSemestres() {
		return this.semestres;
	}

	public void setSemestres(Integer semestres) {
		this.semestres = semestres;
	}
}
