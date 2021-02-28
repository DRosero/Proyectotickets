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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diego
 */
@ManagedBean
@SessionScoped
public class BeanTicket {
    @EJB
    private final CtrlTicket ctrlTicket;
        
    Ticket ticket=new Ticket();
    Usuario usuario=new Usuario();
                
    /**
     * Creates a new instance of BeanTicket
     */
    public BeanTicket() {               
        this.ctrlTicket = new CtrlTicket();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public Date obtenerFechaActual (){
        Date date = new Date();
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(date);               
        return date;
    }         
    
    public int asignarNumeroTicket(){
        int numeroTicket=0;
        numeroTicket++;        
        return numeroTicket;
    }
    
    public void crearTicket(){
        usuario.setIdUsuario(1);
        ticket.setNumeroTicket(asignarNumeroTicket());        
        ticket.setDealsTicket("Mobile deals");
        ticket.setIdUsuario(usuario);        
        ticket.setEstadoTicket("Abierto");
        ticket.setFechaTicket(obtenerFechaActual());        
        ctrlTicket.crearTicket(ticket);          
    }
    
    public List<Ticket> consultarTodosTicket(){
        return ctrlTicket.consultarTodos();
    }
    public List<Ticket> consultarTicketporEstadoBean(){        
        List<Ticket> listaTicket=new ArrayList<>();        
        listaTicket=ctrlTicket.consultaTicketporEstadoCtrl(ticket);
        return listaTicket;
    }
    
}
