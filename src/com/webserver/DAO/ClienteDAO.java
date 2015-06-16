package com.webserver.DAO;


import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.webserver.bean.TbCliente;
import com.webserver.util.HibernateUtil;

public class ClienteDAO {
	
	private Session session;
	
	public void init (){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
	}
	
	
	public TbCliente buscarClientexDNI(long dniCliente){
		init();	
		TbCliente cliente = (TbCliente) session.createCriteria(TbCliente.class,"Cliente").add(Restrictions.like("Cliente.inDni", dniCliente)).uniqueResult();
		session.close();
		return cliente;
	}
	
	public boolean existeCliente(long dniCliente){
		init();
		boolean rpta;
		TbCliente cliente = (TbCliente) session.createCriteria(TbCliente.class,"Cliente").add(Restrictions.like("Cliente.inDni", dniCliente)).uniqueResult();
		session.close();
		if (cliente != null){
			rpta=true;
		}else{
			rpta=false;
			
		}
		return rpta;
	}
	
	public void actualizarCliente(){
		
		
	}
	
	
}
