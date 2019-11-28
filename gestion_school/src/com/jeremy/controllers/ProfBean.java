package com.jeremy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Matiere;
import com.jeremy.model.Professeur;
import com.jeremy.service.Iservice;
@Component
public class ProfBean {
	@Autowired
	Iservice service;
	private Professeur prof = new Professeur();
	private List tabProf = new ArrayList<>();
	private Professeur profSelected = new Professeur();
	
	
	private CommandButton submit = new CommandButton();
	private CommandButton up = new CommandButton();
	private CommandButton del = new CommandButton();
	private CommandButton reset = new CommandButton();
	
	@PostConstruct
	
	public void initiate() {
		reset.setDisabled(true);
		up.setDisabled(true);
	}
	
	public List getTabProf() {
		tabProf = service.getObjects("Professeur");
		return tabProf;
	}
	public void setTabProf(List tabProf) {
		this.tabProf = tabProf;
	}
	public Professeur getProfSelected() {
		return profSelected;
	}
	public void setProfSelected(Professeur profSelected) {
		this.profSelected = profSelected;
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
	public void inscrire() {
		
		try {
			
			service.addObject(prof);
			info();
			viderFormulaire(prof);
			System.out.println(tabProf.size());
			 }
			 catch (DataIntegrityViolationException e) {
				 error();
			 }
		reset.setDisabled(false);
		del.setDisabled(false);
		up.setDisabled(false);
	}
	public void onChange() {
		prof=profSelected;
	}
	public void annuler() {
		viderFormulaire(prof);
	}
	public void viderFormulaire (Professeur objProf ) 
	{
		objProf.setNumProf(null);
		objProf.setNomProf(null);
		objProf.setPrenomProf(null);
		objProf.setTelProf(null);
		
	}
	
	public void modifier() {
		service.updateObject(prof);
		update();
	}
	/*public void supprimer() {
		service.deleteObject(prof);
		viderFormulaire(prof);
		delete();
	}*/
	
	public void info()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Vous avez bien inscrit en tant que prof!"));
	}
	public void error()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Ce matricule appartient déja à un prof!"));
	}
	/*public void delete()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ", "Matière supprimée!"));
	}*/
	public void update()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ", "Les informations ont bien été Modifiées!"));
	}
	public Iservice getService() {
		return service;
	}
	public void setService(Iservice service) {
		this.service = service;
	}
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	
}
