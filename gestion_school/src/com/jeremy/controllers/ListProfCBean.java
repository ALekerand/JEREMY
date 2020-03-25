package com.jeremy.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;
import com.jeremy.model.Professeur;
import com.jeremy.query.RequeteProf;
import com.jeremy.service.Iservice;

@Component
public class ListProfCBean {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteProf requeteprof;
	
	// creation des objets
	private Professeur listProf = new Professeur();
	private Professeur profSelected = new Professeur();
	
	
	private List<Professeur> allProf = new ArrayList<>();
	private List<Classe> allClasse = new ArrayList<>();
	
	public void chargeListProf() {
		
		// Exécution de la requête afin de charger la liste concernée 
		allClasse = requeteprof.findClassByProf(profSelected.getNumProf());
	}
	
	
	public Professeur getListProf() {
		return listProf;
	}
	public void setListProf(Professeur listProf) {
		this.listProf = listProf;
	}
	
	public List getAllProf() {
		if(allProf.isEmpty()) {
			allProf = getService().getObjects("Professeur");
		}
		return allProf;
	}
	public void setAllProf(List allProf) {
		this.allProf = allProf;
	}
	public Iservice getService() {
		return service;
	}
	public void setService(Iservice service) {
		this.service = service;
	}
	public Professeur getProfSelected() {
		return profSelected;
	}


	public void setProfSelected(Professeur profSelected) {
		this.profSelected = profSelected;
	}

	public List getAllClasse() {
		return allClasse;
	}


	public void setAllClasse(List allClasse) {
		this.allClasse = allClasse;
	}
	
}
