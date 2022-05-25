package com.devoir.mestaoui_ghoudan.services;

import com.devoir.mestaoui_ghoudan.models.Admin;
import com.devoir.mestaoui_ghoudan.models.Ticket;

import java.util.List;

public interface AdminService {
    void ajouter(Admin admin);
    void modifier(Admin admin);
    void delete(long id);
    List<Admin> getAll();
    Admin get(long id);
    List<Ticket> getTicketsNonAttribue();
    void attribuerTicket(long idDev, long idT);
}
