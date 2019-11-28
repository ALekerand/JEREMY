package com.jeremy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.PropertyValueException;
import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.jeremy.model.Classe;
import com.jeremy.model.Matiere;
import com.jeremy.model.Professeur;
import com.jeremy.service.Iservice;

@Component
public class ClassBean {
	@Autowired
	Iservice service;
	//Declaration des objets
	private Classe classrom = new Classe();
	private Classe classSelected = new Classe();
	
	private List myListClass = new ArrayList<>();
	private List myListProf = new ArrayList<>();
	private List tabClass = new ArrayList<>();
	
	private Professeur choixProf = new Professeur();
	private CommandButton submit = new CommandButton();
	private CommandButton up = new CommandButton();
	private CommandButton del = new CommandButton();
	private CommandButton reset = new CommandButton();


	@PostConstruct
	public void initiate(){
		submit.setDisabled(false);
		reset.setDisabled(true);
		del.setDisabled(true);
		up.setDisabled(true);
	
	}

		//Les Getters et les Setters
		public List getMyListProf() {
			if(myListProf.isEmpty()) {
				myListProf = getService().getObjects("Professeur");
			}
			return myListProf;
		}
	
		
		
		public void setMyListProf(List myListProf) {
			this.myListProf = myListProf;
		}
		public List getTabClass() {
			tabClass = service.getObjects("Classe");
			return tabClass;
		}

		
		public Classe getClassSelected() {
			return classSelected;
		}

		public void setClassSelected(Classe classSelected) {
			this.classSelected = classSelected;
		}
		
		
		public void setTabClass(List tabClass) {
			this.tabClass = tabClass;
		}
		
		public CommandButton getReset() {
			return reset;
		}

		
		
		public void setReset(CommandButton reset) {
			this.reset = reset;
		}	
		
		public Professeur getChoixProf() {
			return choixProf;
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

		public void setChoixProf(Professeur choixProf) {
			this.choixProf = choixProf;
		}
		
		

		public Iservice getService() {
			return service;
		}
		public void setService(Iservice service) {
			this.service = service;
		}
		
		
		public Classe getClassrom() {
			return classrom;
		}
		public void setClassrom(Classe classrom) {
			this.classrom = classrom;
		}
		
		
	public void inscrire(){
	try {
		try {	
		classrom.setProfesseur(choixProf);
		classrom.setNomClasse(classrom.getNomClasse().toUpperCase());
			service.addObject(classrom);
			update_prof();
			info();
			viderFormulaire(classrom);
			 }
			 catch (PropertyValueException e) {
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
	public void update_prof() {
		choixProf.setClasse(classrom);
		service.updateObject(choixProf);
	}
	
	
	
	public void annuler() {
		viderFormulaire(classrom);
	}
	public void modifier() {
		service.updateObject(classrom);
		update();
	}
	public void supprimer() {
		service.deleteObject(classrom);
		viderFormulaire(classrom);
		delete();
	}
	public void onChange() {
		classrom= classSelected;
	}
	
	public void viderFormulaire (Classe objclass ) 
	{
		objclass.setNomClasse(null);
		objclass.setCodeClasse(0);
	}
	public void info()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Vous êtes bien inscrit!"));
	}
	public void error()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Ce matricule existe pour un autre prof"));
	}
	public void fatal()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Un Prof principal obligatoirement!"));
	}
	public void delete()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ", "Vous avez supprimé!"));
	}
	public void update()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ", "Vous avez modifié!"));
	}
	
}
