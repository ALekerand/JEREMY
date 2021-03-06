package com.jeremy.model;
// Generated 31 mai 2019 17:12:34 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Eleve generated by hbm2java
 */
@Entity
@Table(name = "eleve", catalog = "new_project")
public class Eleve implements java.io.Serializable {

	private String numEleve;
	private Classe classe;
	private String nom;
	private String prenom;
	private Date dateNaissance;

	public Eleve() {
	}

	public Eleve(String numEleve, Classe classe) {
		this.numEleve = numEleve;
		this.classe = classe;
	}

	public Eleve(String numEleve, Classe classe, String nom, String prenom, Date dateNaissance) {
		this.numEleve = numEleve;
		this.classe = classe;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	@Id

	@Column(name = "NUM_ELEVE", unique = true, nullable = false, length = 10)
	public String getNumEleve() {
		return this.numEleve;
	}

	public void setNumEleve(String numEleve) {
		this.numEleve = numEleve;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_CLASSE", nullable = false)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Column(name = "NOM", length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	@Column(name = "PRENOM", length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.toUpperCase();
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
