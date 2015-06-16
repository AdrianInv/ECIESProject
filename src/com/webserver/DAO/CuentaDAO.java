package com.webserver.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.webserver.bean.TbCliente;
import com.webserver.bean.TbCuenta;
import com.webserver.util.HibernateUtil;

public class CuentaDAO {

private Session session;
	
	public void init (){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
	}
	
	public List<TbCuenta> buscarClientexDNI(TbCliente cliente){
		init();	
		@SuppressWarnings("unchecked")
		List <TbCuenta> cuentas =  (List<TbCuenta>) session.createCriteria(TbCliente.class,"TbCuenta").add(Restrictions.like("TbCuenta.tbCliente.inDni", cliente.getInDni()));
		session.close();
		return cuentas;
	}
}
