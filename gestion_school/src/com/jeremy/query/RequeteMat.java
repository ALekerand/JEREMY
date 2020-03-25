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
import com.jeremy.model.Enseigner;

/**
 * @author ndri
 *
 */
@Transactional
@Component
public class RequeteMat {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Enseigner> findMatByClasse(int code) {
		
		String query = "SELECT * FROM `enseigner` WHERE `CODE_CLASSE`="+code+"";
		
		List<Enseigner> allMat = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Enseigner.class).list();
		
		return allMat;
		
		//
		
	}
	

}
