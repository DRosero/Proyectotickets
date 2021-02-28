/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.dao;

import com.ticket.entidad.Ticket;
import com.ticket.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diego
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> {

    @PersistenceContext(unitName = "Ticket-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }
    
    public List<Ticket> consultarTicketporEstado(Ticket ticket){
        List<Ticket> listaTicket=new ArrayList<>();
        Query q1 = em.createQuery("SELECT T FROM Ticket T where T.estadoTicket=:estadoTicket");
        q1.setParameter("estadoTicket", ticket);
        listaTicket = (List<Ticket>) q1.getResultList();                
        return listaTicket;
    }
    
}
