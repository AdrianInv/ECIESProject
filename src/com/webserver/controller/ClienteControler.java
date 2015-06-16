package com.webserver.controller;

import java.util.Date;
import java.util.List;

import com.webserver.DAO.ClienteDAO;
import com.webserver.DAO.CuentaDAO;
import com.webserver.bean.TbCliente;
import com.webserver.bean.TbCuenta;

public class ClienteControler {
	
	private ClienteDAO clientedao;
	private CuentaDAO cuentadao;
	private TbCliente cliente;
	private long dni;
	private long token;
	private Date fechaActual;
	private List <TbCuenta> listaCuentas;
	
	public ClienteControler(){
		this.cliente = new TbCliente();
		this.clientedao = new ClienteDAO();
		
	}
	
	public Date fechaActual(){
		fechaActual = new Date();
		return fechaActual;
	}
	
	public boolean usuarioExiste(){
		cliente = clientedao.buscarClientexDNI(dni);
		if(cliente != null){
			return true;
		}else{
			return false;
		}
	}
	
	public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		return (int) dias;
	}
	
	public static int diferenciaEnMinutos(Date fechaMayor, Date fechaMenor) {
		long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEn_ms / (1000 * 60);
		return (int) dias;
	}
	
	
	public void loginCliente(){
		String page = "/index";
		int primerEstado = 0;
		int intentos = 0;
		TbCliente cliente = new TbCliente();
		if (dni==0 && token==0){
			//enviar mensaje SE NECESITAN AMBOS CAMPOS
		}else{
			if (usuarioExiste ()){
				cliente = clientedao.buscarClientexDNI(dni);
				System.out.println(cliente.getInEstado());
				if(!(cliente.getInEstado()==2)){
					primerEstado = cliente.getInEstado();
				}
				listaCuentas = cuentadao.buscarClientexDNI(cliente);
				//req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			    //req.getSession().setAttribute("sesionusuario",usuario);
				if (cliente.getInEstado() == 1){ //Usuario activo.
					if (diferenciaEnDias(fechaActual(),cliente.getDtFecharegistro()) < 90){
						cliente.setInNumerointentos(0);
						cliente.setDtUltimoingreso(fechaActual());
						page = "/bienvenidausuario";
					}else{
						cliente.setDtFecharegistro(fechaActual());
						//usuario.setDateAttempt(fechaActual());
						//usuario.setChangePwd("1");
						page = "/cambiacontrasena";
					}
				}else{
					if (cliente.getInEstado() == 2){ //Usuario bloqueado
						if (diferenciaEnMinutos(fechaActual(), cliente.getDtFecharegistro())<2){
							//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario bloqueado.", null));
						}else{
							cliente.setInEstado(primerEstado);
							cliente.setInNumerointentos(0);
							cliente.setDtUltimoingreso(fechaActual());
							//usuario.setDateAttempt(fechaActual());
							//usuario.setAttempt("0");
							//usuarioDao.actualizaUsuario(usuario);
							if (cliente.getInEstado() == 1 && diferenciaEnDias(fechaActual(),cliente.getDtFecharegistro()) < 90){ //Validación luego del desbloque del usuario.
								cliente.setDtUltimoingreso(fechaActual());
								cliente.setInNumerointentos(0);
								//usuario.setAttempt("0");
								//usuario.setDateAttempt(fechaActual());
								//usuarioDao.actualizaUsuario(usuario);
								page = "/listarcomercios";
							}else{
								if (cliente.getInEstado() == 3 ||cliente.getInEstado() == 0){
									//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado o desactivado.", null));
								}else{
									cliente.setDtUltimoingreso(fechaActual());
									//usuario.setDateAttempt(fechaActual());
									page = "/cambiacontrasena";
								}
							}
						}
					}else{
						if (cliente.getInEstado() == 3 ||cliente.getInEstado() == 0){ //Usuario inactivo o eliminado.
							//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado o desactivado.", null));
							//usuario.setDateAttempt(fechaActual());
							//usuarioDao.actualizaUsuario(usuario);
						}
						
					}
					
				}
				
			}else{
				if (clientedao.existeCliente(dni)){
					cliente = clientedao.buscarClientexDNI(dni);
					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta, ingrese nuevamente.", null));
					if(cliente.getInNumerointentos()<3){
						intentos = intentos+1;
						cliente.setInNumerointentos(intentos);
						cliente.setDtUltimoingreso(fechaActual());
						//usuarioDao.actualizaUsuario(usuario);
						
					}else{
						//usuarioDao.actualizaEstado(usuario.getIdUser(), "2");
					    //System.out.println(usuario.getState());
						cliente.setDtUltimoingreso(fechaActual());
						
						//usuarioDao.actualizaUsuario(usuario);
					}
				}else{
					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario incorrecto, ingrese nuevamente.", null));
				}
			}
		}
	}
	
	public CuentaDAO getCuentadao() {
		return cuentadao;
	}

	public void setCuentadao(CuentaDAO cuentadao) {
		this.cuentadao = cuentadao;
	}

	public TbCliente getCliente() {
		return cliente;
	}

	public void setCliente(TbCliente cliente) {
		this.cliente = cliente;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public List<TbCuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<TbCuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public ClienteDAO getClientedao() {
		return clientedao;
	}


	public void setClientedao(ClienteDAO clientedao) {
		this.clientedao = clientedao;
	}


}
