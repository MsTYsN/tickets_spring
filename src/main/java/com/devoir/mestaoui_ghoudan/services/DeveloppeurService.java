package com.devoir.mestaoui_ghoudan.services;

import com.devoir.mestaoui_ghoudan.models.Developpeur;
import com.devoir.mestaoui_ghoudan.models.Ticket;

import java.util.List;

public interface DeveloppeurService {
    void ajouter(Developpeur developpeur);
    void modifier(Developpeur developpeur);
    void delete(long id);
    List<Developpeur> getAll();
    Developpeur get(long id);
    List<Ticket> getDeveloppeurTickets(long id);
    void statutTicket(long id, String etat);
}
