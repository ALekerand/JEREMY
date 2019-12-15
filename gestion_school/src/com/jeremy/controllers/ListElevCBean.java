package com.jeremy.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;
import com.jeremy.query.RequeteEleve;
import com.jeremy.service.Iservice;

@Component
public class ListElevCBean {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteEleve requeteEleve;
	
	// creation des objets
	private Classe listClasse = new Classe();
	private Classe classSelected = new Classe();
	
	
	private List<Classe> allClasse = new ArrayList<>();
	private List<Eleve> allStudent = new ArrayList<>();
	
	public void chargeListEleve() {
		
		// Exécution de la requête afin de charger la liste concernée 
		allStudent = requeteEleve.findStudentByClass(classSelected.getCodeClasse());
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
	public Classe getClassSelected() {
		return classSelected;
	}


	public void setClassSelected(Classe classSelected) {
		this.classSelected = classSelected;
	}

	public List getAllStudent() {
		return allStudent;
	}


	public void setAllStudent(List allStudent) {
		this.allStudent = allStudent;
	}
	
}
