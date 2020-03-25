/**
 * 
 */
package com.jeremy.query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.model.Classe;
import com.jeremy.model.Eleve;

/**
 * @author ndri
 *
 */
@Transactional
@Component
public class RequeteProf {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Classe> findClassByProf(String code) {
		String query = "SELECT * FROM `classe` WHERE `NUM_PROF`="+code+"";
		
		List<Classe> allclasse = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Classe.class).list();
		
		return allclasse;
		
		//
		
		
		
	}
	

}
