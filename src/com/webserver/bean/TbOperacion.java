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
 * TbOperacion generated by hbm2java
 */
@Entity
@Table(name="tb_operacion"
    ,catalog="abcdatabase"
)
public class TbOperacion  implements java.io.Serializable {


     private int inIdoperacion;
     private TbCuenta tbCuenta;
     private String vcTipooperacion;
     private String vcServicio;
     private Integer inIdproveedor;
     private Date dtFechaoperacion;
     private Date dtIniciooperacion;
     private Date dtFinoperacion;
     private Set tbTransaccions = new HashSet(0);

    public TbOperacion() {
    }

	
    public TbOperacion(int inIdoperacion, TbCuenta tbCuenta) {
        this.inIdoperacion = inIdoperacion;
        this.tbCuenta = tbCuenta;
    }
    public TbOperacion(int inIdoperacion, TbCuenta tbCuenta, String vcTipooperacion, String vcServicio, Integer inIdproveedor, Date dtFechaoperacion, Date dtIniciooperacion, Date dtFinoperacion, Set tbTransaccions) {
       this.inIdoperacion = inIdoperacion;
       this.tbCuenta = tbCuenta;
       this.vcTipooperacion = vcTipooperacion;
       this.vcServicio = vcServicio;
       this.inIdproveedor = inIdproveedor;
       this.dtFechaoperacion = dtFechaoperacion;
       this.dtIniciooperacion = dtIniciooperacion;
       this.dtFinoperacion = dtFinoperacion;
       this.tbTransaccions = tbTransaccions;
    }
   
     @Id 

    
    @Column(name="IN_IDOPERACION", unique=true, nullable=false)
    public int getInIdoperacion() {
        return this.inIdoperacion;
    }
    
    public void setInIdoperacion(int inIdoperacion) {
        this.inIdoperacion = inIdoperacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TB_CUENTA_IN_IDCUENTA", nullable=false)
    public TbCuenta getTbCuenta() {
        return this.tbCuenta;
    }
    
    public void setTbCuenta(TbCuenta tbCuenta) {
        this.tbCuenta = tbCuenta;
    }

    
    @Column(name="VC_TIPOOPERACION", length=45)
    public String getVcTipooperacion() {
        return this.vcTipooperacion;
    }
    
    public void setVcTipooperacion(String vcTipooperacion) {
        this.vcTipooperacion = vcTipooperacion;
    }

    
    @Column(name="VC_SERVICIO", length=45)
    public String getVcServicio() {
        return this.vcServicio;
    }
    
    public void setVcServicio(String vcServicio) {
        this.vcServicio = vcServicio;
    }

    
    @Column(name="IN_IDPROVEEDOR")
    public Integer getInIdproveedor() {
        return this.inIdproveedor;
    }
    
    public void setInIdproveedor(Integer inIdproveedor) {
        this.inIdproveedor = inIdproveedor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DT_FECHAOPERACION", length=10)
    public Date getDtFechaoperacion() {
        return this.dtFechaoperacion;
    }
    
    public void setDtFechaoperacion(Date dtFechaoperacion) {
        this.dtFechaoperacion = dtFechaoperacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_INICIOOPERACION", length=19)
    public Date getDtIniciooperacion() {
        return this.dtIniciooperacion;
    }
    
    public void setDtIniciooperacion(Date dtIniciooperacion) {
        this.dtIniciooperacion = dtIniciooperacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DT_FINOPERACION", length=19)
    public Date getDtFinoperacion() {
        return this.dtFinoperacion;
    }
    
    public void setDtFinoperacion(Date dtFinoperacion) {
        this.dtFinoperacion = dtFinoperacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbOperacion")
    public Set getTbTransaccions() {
        return this.tbTransaccions;
    }
    
    public void setTbTransaccions(Set tbTransaccions) {
        this.tbTransaccions = tbTransaccions;
    }




}

