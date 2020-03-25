package com.jeremy.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.PropertyValueException;
import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Enseigner;
import com.jeremy.model.Matiere;
import com.jeremy.model.Professeur;
import com.jeremy.service.Iservice;

@Component
public class EnseignerBean {
	@Autowired
	Iservice service;
	//Declaration des objets
	
	private Professeur choixProf = new Professeur();
	private Classe choixClass = new Classe();
	private Matiere choixMat = new Matiere();
	private Enseigner ens = new Enseigner();
	
	private List tabEns = new ArrayList<>();
	
	private List myListClass = new ArrayList<>();
	private List myListProf = new ArrayList<>();
	private List myListMat = new ArrayList<>();
	private List myListEns = new ArrayList<>();
	
	private CommandButton submit = new CommandButton();
	
	
	public Enseigner getEns() {
		return ens;
	}

	public void setEns(Enseigner ens) {
		this.ens = ens;
	}

	public Professeur getChoixProf() {
		return choixProf;
	}

	public void setChoixProf(Professeur choixProf) {
		this.choixProf = choixProf;
	}

	public Classe getChoixClass() {
		return choixClass;
	}

	public void setChoixClass(Classe choixClass) {
		this.choixClass = choixClass;
	}

	public Matiere getChoixMat() {
		return choixMat;
	}

	public void setChoixMat(Matiere choixMat) {
		this.choixMat = choixMat;
	}

	public List getMyListClass() {
		if(myListClass.isEmpty()) {
			myListClass = getService().getObjects("Classe");
		}
		return myListClass;
	}

	public void setMyListClass(List myListClass) {
		this.myListClass = myListClass;
	}

	public List getMyListProf() {
		if(myListProf.isEmpty()) {
			myListProf = getService().getObjects("Professeur");
		}
		return myListProf;
	}

	public void setMyListProf(List myListProf) {
		this.myListProf = myListProf;
	}

	public List getMyListMat() {
		if(myListMat.isEmpty()) {
			myListMat = getService().getObjects("Matiere");
		}
		return myListMat;
	}

	public void setMyListMat(List myListMat) {
		this.myListMat = myListMat;
	}

	public CommandButton getSubmit() {
		return submit;
	}

	public void setSubmit(CommandButton submit) {
		this.submit = submit;
	}
	public Iservice getService() {
		return service;
	}
	public void setService(Iservice service) {
		this.service = service;
	}
	public void inscrire(){
		try {
			try {	
			ens.setProfesseur(choixProf);
			ens.setClasse(choixClass);
			ens.setMatiere(choixMat);
			System.out.println("======= code: "+ens.getCodeEns());
			//ens.setCodeEns(codeEns);
				service.addObject(ens);
				info();
				
				
				 }
				 catch (PropertyValueException e) {
				 }
			}
		catch (DataIntegrityViolationException e) {
			
		 }
			}
	public void info()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Vous êtes bien inscrit!"));
	}
	public void error()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Cet Elève est deja ajouté"));
	}
	public void fatal()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Ajoutez la classe"));
	}
	public void errorUpdate()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Update: ", "Aucune information modifiée"));
	}
	public void update()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success: ", "Vous avez modifié!"));
	}

	public List getMyListEns() {
		if(myListEns.isEmpty()) {
			myListEns = getService().getObjects("Enseigner");
		}
		return myListEns;
	}

	public void setMyListEns(List myListEns) {
		this.myListEns = myListEns;
	}

	public List getTabEns() {
		tabEns = service.getObjects("Enseigner");
		return tabEns;
	}

	public void setTabEns(List tabEns) {
		this.tabEns = tabEns;
	}
}
