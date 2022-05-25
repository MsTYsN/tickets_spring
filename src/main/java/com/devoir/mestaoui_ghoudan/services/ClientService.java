package com.devoir.mestaoui_ghoudan.services;

import com.devoir.mestaoui_ghoudan.models.Client;
import com.devoir.mestaoui_ghoudan.models.Ticket;

import java.util.List;

public interface ClientService {
    void ajouter(Client client);
    void modifier(Client client);
    void delete(long id);
    List<Client> getAll();
    Client get(long id);
    List<Ticket> getTickets(long id);
    void creerTicket(Ticket ticket);
}
