/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket"),
    @NamedQuery(name = "Ticket.findByNumeroTicket", query = "SELECT t FROM Ticket t WHERE t.numeroTicket = :numeroTicket"),
    @NamedQuery(name = "Ticket.findByDescripcionTicket", query = "SELECT t FROM Ticket t WHERE t.descripcionTicket = :descripcionTicket"),
    @NamedQuery(name = "Ticket.findByEstadoTicket", query = "SELECT t FROM Ticket t WHERE t.estadoTicket = :estadoTicket"),
    @NamedQuery(name = "Ticket.findByPrioridadTicket", query = "SELECT t FROM Ticket t WHERE t.prioridadTicket = :prioridadTicket"),
    @NamedQuery(name = "Ticket.findByFechaTicket", query = "SELECT t FROM Ticket t WHERE t.fechaTicket = :fechaTicket"),
    @NamedQuery(name = "Ticket.findByDealsTicket", query = "SELECT t FROM Ticket t WHERE t.dealsTicket = :dealsTicket")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TICKET")
    private Integer idTicket;
    @Column(name = "NUMERO_TICKET")
    private Integer numeroTicket;
    @Size(max = 200)
    @Column(name = "DESCRIPCION_TICKET")
    private String descripcionTicket;
    @Size(max = 10)
    @Column(name = "ESTADO_TICKET")
    private String estadoTicket;
    @Size(max = 20)
    @Column(name = "PRIORIDAD_TICKET")
    private String prioridadTicket;
    @Column(name = "FECHA_TICKET")
    @Temporal(TemporalType.DATE)
    private Date fechaTicket;
    @Size(max = 20)
    @Column(name = "DEALS_TICKET")
    private String dealsTicket;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(Integer numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getDescripcionTicket() {
        return descripcionTicket;
    }

    public void setDescripcionTicket(String descripcionTicket) {
        this.descripcionTicket = descripcionTicket;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public String getPrioridadTicket() {
        return prioridadTicket;
    }

    public void setPrioridadTicket(String prioridadTicket) {
        this.prioridadTicket = prioridadTicket;
    }

    public Date getFechaTicket() {
        return fechaTicket;
    }

    public void setFechaTicket(Date fechaTicket) {
        this.fechaTicket = fechaTicket;
    }

    public String getDealsTicket() {
        return dealsTicket;
    }

    public void setDealsTicket(String dealsTicket) {
        this.dealsTicket = dealsTicket;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ticket.entidad.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
