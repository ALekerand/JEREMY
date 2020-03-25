package com.jeremy.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;
import com.jeremy.model.Professeur;
import com.jeremy.query.RequeteAllProf;
import com.jeremy.query.RequeteEleve;
import com.jeremy.service.Iservice;

@Component
public class ListAllProfBean {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteAllProf requeteAllProf;
	
	// creation des objets
	
	
	private List<Professeur> allProf = new ArrayList<>();
	
	
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
}
