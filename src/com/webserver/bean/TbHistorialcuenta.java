package com.webserver.bean;
// Generated 15-jun-2015 20:55:52 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbHistorialcuenta generated by hbm2java
 */
@Entity
@Table(name="tb_historialcuenta"
    ,catalog="abcdatabase"
)
public class TbHistorialcuenta  implements java.io.Serializable {


     private int inIdbalancefecha;
     private TbCuenta tbCuenta;
     private Date dtFechainicio;
     private Date dtFechafin;
     private Double doMontofinal;

    public TbHistorialcuenta() {
    }

	
    public TbHistorialcuenta(int inIdbalancefecha, TbCuenta tbCuenta) {
        this.inIdbalancefecha = inIdbalancefecha;
        this.tbCuenta = tbCuenta;
    }
    public TbHistorialcuenta(int inIdbalancefecha, TbCuenta tbCuenta, Date dtFechainicio, Date dtFechafin, Double doMontofinal) {
       this.inIdbalancefecha = inIdbalancefecha;
       this.tbCuenta = tbCuenta;
       this.dtFechainicio = dtFechainicio;
       this.dtFechafin = dtFechafin;
       this.doMontofinal = doMontofinal;
    }
   
     @Id 

    
    @Column(name="IN_IDBALANCEFECHA", unique=true, nullable=false)
    public int getInIdbalancefecha() {
        return this.inIdbalancefecha;
    }
    
    public void setInIdbalancefecha(int inIdbalancefecha) {
        this.inIdbalancefecha = inIdbalancefecha;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TB_CUENTA_IN_IDCUENTA", nullable=false)
    public TbCuenta getTbCuenta() {
        return this.tbCuenta;
    }
    
    public void setTbCuenta(TbCuenta tbCuenta) {
        this.tbCuenta = tbCuenta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_FECHAINICIO", length=19)
    public Date getDtFechainicio() {
        return this.dtFechainicio;
    }
    
    public void setDtFechainicio(Date dtFechainicio) {
        this.dtFechainicio = dtFechainicio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_FECHAFIN", length=19)
    public Date getDtFechafin() {
        return this.dtFechafin;
    }
    
    public void setDtFechafin(Date dtFechafin) {
        this.dtFechafin = dtFechafin;
    }

    
    @Column(name="DO_MONTOFINAL", precision=22, scale=0)
    public Double getDoMontofinal() {
        return this.doMontofinal;
    }
    
    public void setDoMontofinal(Double doMontofinal) {
        this.doMontofinal = doMontofinal;
    }




}


