package com.jeremy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;

import org.hibernate.StaleStateException;
import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.jeremy.service.Iservice;
import com.jeremy.model.Classe;
import com.jeremy.model.Matiere;
import com.jeremy.model.Professeur;
@Component
public class MatiereBean {
		@Autowired
		Iservice service;
	private Matiere mat= new Matiere();
	private List tabMatiere = new ArrayList<>();
	private Matiere matSelected = new Matiere();
	
	
	private CommandButton submit = new CommandButton();
	private CommandButton up = new CommandButton();
	private CommandButton del = new CommandButton();
	private CommandButton reset = new CommandButton();
	
	@PostConstruct
	public void initiate(){
		reset.setDisabled(true);
		del.setDisabled(true);
		up.setDisabled(true);
	
	}
	public Matiere getMatSelected() {
		return matSelected;
	}
	public void setMatSelected(Matiere matSelected) {
		this.matSelected = matSelected;
	}
	
	public List getTabMatiere() {
		tabMatiere = service.getObjects("Matiere");
		return tabMatiere;
	}
	public void setTabMatiere(List tabMatiere) {
		this.tabMatiere = tabMatiere;
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
	public void inscrire() {
		
		try {
			service.addObject(mat);
			info();
			viderFormulaire(mat);
			 }
			 catch (DataIntegrityViolationException e) {
				 error();
			 }
		reset.setDisabled(false);
		del.setDisabled(false);
		up.setDisabled(false);
	}
	public void onChange() {
		mat=matSelected;
	}
	public void annuler() {
		viderFormulaire(mat);
	}
	public void viderFormulaire (Matiere objMat ) 
	{
		
		objMat.setCodeMatiere(null);
		objMat.setLibelleMatiere(null);
		
	}
	
	public void modifier() {
			service.updateObject(mat);
			update();
		
		
	}
	
	public void info()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Matière ajoutée avec succès!"));
	}
	public void error()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Cette matière ne peut-être dupliquée!"));
	}
	public void update()
	{
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ", "Matière Modifiée avec succès!"));
	}
	public Iservice getService() {
		return service;
	}
	public void setService(Iservice service) {
		this.service = service;
	}
	public Matiere getMat() {
		return mat;
	}
	public void setMat(Matiere mat) {
		this.mat = mat;
	}
	public CommandButton getReset() {
		return reset;
	}
	public void setReset(CommandButton reset) {
		this.reset = reset;
	}
}
