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

import com.jeremy.service.Iservice;
import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;
@Component
public class EleveBean {
	@Autowired
	Iservice service;
private Eleve el = new Eleve();
private List myListClass = new ArrayList<>();
private Classe choixClass = new Classe();

private List tabEleve = new ArrayList<>();
private Eleve eleveSelected = new Eleve();
private CommandButton submit = new CommandButton();
private CommandButton up = new CommandButton();
private CommandButton del = new CommandButton();
private CommandButton reset = new CommandButton();

public List getTabEleve() {
	tabEleve = service.getObjects("Eleve");
	return tabEleve;
}



public void setTabEleve(List tabEleve) {
	this.tabEleve = tabEleve;
}







public Eleve getEleveSelected() {
	return eleveSelected;
}



public void setEleveSelected(Eleve eleveSelected) {
	this.eleveSelected = eleveSelected;
}



public CommandButton getSubmit() {
	return submit;
}



public void setSubmit(CommandButton submit) {
	this.submit = submit;
}



public CommandButton getUp() {
	return up;
}



public void setUp(CommandButton up) {
	this.up = up;
}



public CommandButton getDel() {
	return del;
}



public void setDel(CommandButton del) {
	this.del = del;
}



public CommandButton getReset() {
	return reset;
}



public void setReset(CommandButton reset) {
	this.reset = reset;
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



public Classe getChoixClass() {
	return choixClass;
}



public void setChoixClass(Classe choixClass) {
	this.choixClass = choixClass;
}



public Iservice getService() {
	return service;
}



public void setService(Iservice service) {
	this.service = service;
}



public Eleve getEl() {
	return el;
}



public void setEl(Eleve el) {
	this.el = el;
}



public void inscrire(){
try {
	
	try {
		el.setClasse(choixClass);
		service.addObject(el);
		info();
		viderFormulaire(el);
		 }
	catch (PropertyValueException e) 
		{
	 fatal();
		}
	}
catch (DataIntegrityViolationException e) {
error();
}
	reset.setDisabled(false);
	del.setDisabled(false);
	up.setDisabled(false);
	}



public void annuler() {
	viderFormulaire(el);
}
public void modifier() {
	el.setClasse(choixClass);
	if(el != eleveSelected) {
		service.updateObject(el);
		update();
		
		
	}
	if(el== eleveSelected){
		errorUpdate();
	}

}

public void onChange() {
	el= eleveSelected;
}
public void viderFormulaire (Eleve objEl ) 
{
	
	objEl.setNumEleve(null);
	objEl.setNom(null);
	objEl.setPrenom(null);
	objEl.setDateNaissance(null);
	objEl.setClasse(null);
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
}
