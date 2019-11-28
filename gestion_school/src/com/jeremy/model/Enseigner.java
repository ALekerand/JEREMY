package com.jeremy.model;
// Generated 31 mai 2019 17:12:34 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Enseigner generated by hbm2java
 */
@Entity
@Table(name = "enseigner", catalog = "new_project")
public class Enseigner implements java.io.Serializable {

	private String codeEns;
	private Professeur professeur;
	private Matiere matiere;
	private Classe classe;

	public Enseigner() {
	}

	public Enseigner(String codeEns, Professeur professeur) {
		this.codeEns = codeEns;
		this.professeur = professeur;
	}

	public Enseigner(String codeEns, Professeur professeur, Matiere matiere, Classe classe) {
		this.codeEns = codeEns;
		this.professeur = professeur;
		this.matiere = matiere;
		this.classe = classe;
	}

	@Id
	
	@Column(name = "CODE_ENS", unique = true, nullable = false, length = 5)
	public String getCodeEns() {
		return this.codeEns;
	}

	public void setCodeEns(String codeEns) {
		this.codeEns = codeEns;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NUM_PROF", nullable = false)
	public Professeur getProfesseur() {
		return this.professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_MATIERE")
	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_CLASSE")
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
