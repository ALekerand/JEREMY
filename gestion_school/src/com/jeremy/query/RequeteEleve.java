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

/**
 * @author ndri
 *
 */
@Transactional
@Component
public class RequeteEleve {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Eleve> findStudentByClass(int code) {
		
		String query = "SELECT * FROM `eleve` WHERE `CODE_CLASSE`="+code+"";
		
		List<Eleve> allStudent = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Eleve.class).list();
		
		return allStudent;
		
		//
		
		
		
	}
	

}
