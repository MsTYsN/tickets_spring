package com.devoir.mestaoui_ghoudan.services;

import com.devoir.mestaoui_ghoudan.models.Ticket;

import java.util.List;

public interface TicketService {
    void ajouter(Ticket ticket);
    void modifier(Ticket ticket);
    void delete(long id);
    List<Ticket> getAll();
    Ticket get(long id);
}
