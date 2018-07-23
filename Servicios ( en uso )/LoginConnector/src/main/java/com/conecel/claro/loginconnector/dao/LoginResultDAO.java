package com.conecel.claro.loginconnector.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.loginconnector.domain.LoginResult;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;

@Service
@Transactional
public class LoginResultDAO implements ILoginResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<LoginResult> obtieneUsuario(PreLoginInfo preLoginInfo) {
	
		List<LoginResult> resultado;
		
		Map<String,String> parametros = new HashMap<>();
		
		String queryGenerated="select rownum id, u.id_usuario userId, u.nombres userDescription, u.username, u.password,\r\n" + 
				"u.id_rol, r.nombre roleName\r\n" + 
				"from rc_usuario u, rc_rol r\r\n" + 
				"where u.id_rol= r.id_rol";
		
		try {
			
	    if(!"".equals(preLoginInfo.getUser()) && !"".equals(preLoginInfo.getPassword()))
	    {
	    	queryGenerated=queryGenerated +" and upper(u.username)= upper(:usuario)";
	    	parametros.put("usuario",preLoginInfo.getUser());
	    	
	    	queryGenerated=queryGenerated +" and upper(u.password)= upper(:clave)";
	    	parametros.put("clave",preLoginInfo.getPassword());
	    	
	    }else
	    {
	    	
	    	return null;
	    }
	    
	    System.out.println("query: " + queryGenerated);
	    
	    TypedQuery<LoginResult> query= (TypedQuery<LoginResult>) this.getEntityManager().createNativeQuery(queryGenerated, LoginResult.class);
	    	
	    parametros.forEach((k,v)-> query.setParameter(k, v));
	    
	    resultado= query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
				
		
		return resultado;
	}
	

	
	
	
	

}
