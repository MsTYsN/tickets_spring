package com.devoir.mestaoui_ghoudan.services;

import com.devoir.mestaoui_ghoudan.models.Admin;
import com.devoir.mestaoui_ghoudan.models.Ticket;
import com.devoir.mestaoui_ghoudan.repository.AdminRepository;
import com.devoir.mestaoui_ghoudan.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void ajouter(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void modifier(Admin admin) {
        Admin a = adminRepository.findById(admin.getId()).get();
        if(a != null) {
            a.setNom(admin.getNom());
            a.setPrenom(admin.getPrenom());
            adminRepository.save(a);
        }
    }

    @Override
    public void delete(long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin get(long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getTicketsNonAttribue() {
        return ticketRepository.getTicketsNonAttribue();
    }

    @Override
    public void attribuerTicket(long idDev, long idT) {
        ticketRepository.attribuerTicket(idDev, idT);
    }
}
