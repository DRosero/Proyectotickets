/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.controlador;

import com.prueba.dao.TicketFacade;
import com.ticket.entidad.Ticket;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Diego
 */
@Stateless
@LocalBean
public class CtrlTicket implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    TicketFacade ticketFacade;

    public CtrlTicket() {
        ticketFacade=new TicketFacade();
    }
    
    public void crearTicket(Ticket ticket){
        ticketFacade.create(ticket);
    }
    
}
