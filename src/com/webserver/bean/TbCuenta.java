package com.webserver.bean;
// Generated 15-jun-2015 20:55:52 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbCuenta generated by hbm2java
 */
@Entity
@Table(name="tb_cuenta"
    ,catalog="abcdatabase"
)
public class TbCuenta  implements java.io.Serializable {


     private int inIdcuenta;
     private TbCliente tbCliente;
     private TbTipocuenta tbTipocuenta;
     private long inNumerocuenta;
     private Date dtFechaapertura;
     private Date dtFechacierre;
     private Double doBalanceactual;
     private String vcEstado;
     private Date dtUltimaoperacion;
     private Set tbHistorialcuentas = new HashSet(0);
     private Set tbOperacions = new HashSet(0);

    public TbCuenta() {
    }

	
    public TbCuenta(int inIdcuenta, TbCliente tbCliente, TbTipocuenta tbTipocuenta, long inNumerocuenta, Date dtFechaapertura, String vcEstado, Date dtUltimaoperacion) {
        this.inIdcuenta = inIdcuenta;
        this.tbCliente = tbCliente;
        this.tbTipocuenta = tbTipocuenta;
        this.inNumerocuenta = inNumerocuenta;
        this.dtFechaapertura = dtFechaapertura;
        this.vcEstado = vcEstado;
        this.dtUltimaoperacion = dtUltimaoperacion;
    }
    public TbCuenta(int inIdcuenta, TbCliente tbCliente, TbTipocuenta tbTipocuenta, long inNumerocuenta, Date dtFechaapertura, Date dtFechacierre, Double doBalanceactual, String vcEstado, Date dtUltimaoperacion, Set tbHistorialcuentas, Set tbOperacions) {
       this.inIdcuenta = inIdcuenta;
       this.tbCliente = tbCliente;
       this.tbTipocuenta = tbTipocuenta;
       this.inNumerocuenta = inNumerocuenta;
       this.dtFechaapertura = dtFechaapertura;
       this.dtFechacierre = dtFechacierre;
       this.doBalanceactual = doBalanceactual;
       this.vcEstado = vcEstado;
       this.dtUltimaoperacion = dtUltimaoperacion;
       this.tbHistorialcuentas = tbHistorialcuentas;
       this.tbOperacions = tbOperacions;
    }
   
     @Id 

    
    @Column(name="IN_IDCUENTA", unique=true, nullable=false)
    public int getInIdcuenta() {
        return this.inIdcuenta;
    }
    
    public void setInIdcuenta(int inIdcuenta) {
        this.inIdcuenta = inIdcuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TB_CLIENTE_IN_IDCLIENTE", nullable=false)
    public TbCliente getTbCliente() {
        return this.tbCliente;
    }
    
    public void setTbCliente(TbCliente tbCliente) {
        this.tbCliente = tbCliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TB_TIPOCUENTA_IN_IDTIPOCUENTA", nullable=false)
    public TbTipocuenta getTbTipocuenta() {
        return this.tbTipocuenta;
    }
    
    public void setTbTipocuenta(TbTipocuenta tbTipocuenta) {
        this.tbTipocuenta = tbTipocuenta;
    }

    
    @Column(name="IN_NUMEROCUENTA", nullable=false)
    public long getInNumerocuenta() {
        return this.inNumerocuenta;
    }
    
    public void setInNumerocuenta(long inNumerocuenta) {
        this.inNumerocuenta = inNumerocuenta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_FECHAAPERTURA", nullable=false, length=19)
    public Date getDtFechaapertura() {
        return this.dtFechaapertura;
    }
    
    public void setDtFechaapertura(Date dtFechaapertura) {
        this.dtFechaapertura = dtFechaapertura;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_FECHACIERRE", length=19)
    public Date getDtFechacierre() {
        return this.dtFechacierre;
    }
    
    public void setDtFechacierre(Date dtFechacierre) {
        this.dtFechacierre = dtFechacierre;
    }

    
    @Column(name="DO_BALANCEACTUAL", precision=22, scale=0)
    public Double getDoBalanceactual() {
        return this.doBalanceactual;
    }
    
    public void setDoBalanceactual(Double doBalanceactual) {
        this.doBalanceactual = doBalanceactual;
    }

    
    @Column(name="VC_ESTADO", nullable=false, length=1)
    public String getVcEstado() {
        return this.vcEstado;
    }
    
    public void setVcEstado(String vcEstado) {
        this.vcEstado = vcEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_ULTIMAOPERACION", nullable=false, length=19)
    public Date getDtUltimaoperacion() {
        return this.dtUltimaoperacion;
    }
    
    public void setDtUltimaoperacion(Date dtUltimaoperacion) {
        this.dtUltimaoperacion = dtUltimaoperacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbCuenta")
    public Set getTbHistorialcuentas() {
        return this.tbHistorialcuentas;
    }
    
    public void setTbHistorialcuentas(Set tbHistorialcuentas) {
        this.tbHistorialcuentas = tbHistorialcuentas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbCuenta")
    public Set getTbOperacions() {
        return this.tbOperacions;
    }
    
    public void setTbOperacions(Set tbOperacions) {
        this.tbOperacions = tbOperacions;
    }




}

