/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.bean;

import com.prueba.controlador.CtrlTicket;
import com.ticket.entidad.Ticket;
import com.ticket.entidad.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class BeanTicket {

    Ticket ticket;
    CtrlTicket ctrlTicket;
    Usuario usuario;
    
    
        
    /**
     * Creates a new instance of BeanTicket
     */
    public BeanTicket() {
        ticket=new Ticket();
        usuario=new Usuario();
        ctrlTicket=new CtrlTicket();
        
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public Date fecha (){
        Date date = new Date();
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(date);               
        return date;
    }
   
    
    
    
    public void crearTicket(){
        usuario.setIdUsuario(1);
        ticket.setNumeroTicket(1);        
        ticket.setDealsTicket("Mobile deals");
        ticket.setIdUsuario(usuario);        
        ticket.setEstadoTicket("Abierto");
        ticket.setFechaTicket(fecha());
        ctrlTicket.crearTicket(ticket);
                        
    }
    
}
