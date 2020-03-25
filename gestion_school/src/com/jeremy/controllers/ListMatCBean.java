package com.jeremy.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;
import com.jeremy.model.Enseigner;
import com.jeremy.model.Matiere;
import com.jeremy.model.Professeur;
import com.jeremy.query.RequeteMat;
import com.jeremy.query.RequeteProf;
import com.jeremy.service.Iservice;

@Component
public class ListMatCBean {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteMat requetemat;
	
	// creation des objets
	private Classe listClasse = new Classe();
	private Classe classeSelected = new Classe();
	
	
	private List<Classe> allClasse = new ArrayList<>();
	private List<Enseigner> allMat = new ArrayList<>();
	
	public void chargeListMat() {
		
		// Exécution de la requête afin de charger la liste concernée 
		allMat = requetemat.findMatByClasse(classeSelected.getCodeClasse());
	}
	
	public List getAllMat() {
		return allMat;
	}


	public void setAllMat(List allMat) {
		this.allMat = allMat;
	}
	public Classe getListClasse() {
		return listClasse;
	}
	public void setListClasse(Classe listClasse) {
		this.listClasse = listClasse;
	}
	
	public List getAllClasse() {
		if(allClasse.isEmpty()) {
			allClasse = getService().getObjects("Classe");
		}
		return allClasse;
	}
	public void setAllClasse(List allClasse) {
		this.allClasse = allClasse;
	}
	public Iservice getService() {
		return service;
	}
	public void setService(Iservice service) {
		this.service = service;
	}
	public Classe getClasseSelected() {
		return classeSelected;
	}


	public void setClasseSelected(Classe classeSelected) {
		this.classeSelected = classeSelected;
	}

}
