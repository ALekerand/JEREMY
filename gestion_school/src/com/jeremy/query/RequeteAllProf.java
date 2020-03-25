/**
 * 
 */
package com.jeremy.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.model.Eleve;
import com.jeremy.model.Professeur;

/**
 * @author ndri
 *
 */
@Transactional
@Component
public class RequeteAllProf {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Professeur> findAllProf() {
		 
		
		String query = "SELECT * FROM `professeur`";
		
		List<Professeur> allProf = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Professeur.class).list();
		
		return allProf;
		
		//
		
		
		
	}
	

}
