package com.devoir.mestaoui_ghoudan.controllers;

import com.devoir.mestaoui_ghoudan.models.Client;
import com.devoir.mestaoui_ghoudan.models.Developpeur;
import com.devoir.mestaoui_ghoudan.models.Ticket;
import com.devoir.mestaoui_ghoudan.repository.ClientRepository;
import com.devoir.mestaoui_ghoudan.repository.TicketRepository;
import com.devoir.mestaoui_ghoudan.repository.UserRepository;
import com.devoir.mestaoui_ghoudan.services.AdminService;
import com.devoir.mestaoui_ghoudan.services.DeveloppeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ModelController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    DeveloppeurService devService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TicketRepository ticketRepository;


    @GetMapping("/home")
    public String home(Model m) {
        return "tickets/home";
    }


    @GetMapping("/admin")
    public String Admin(Model model) {
        List<Developpeur> developpeurs = devService.getAll();
        model.addAttribute("devs", developpeurs);
        model.addAttribute("dev", new Developpeur());
        List<Ticket> tickets = adminService.getTicketsNonAttribue();
        model.addAttribute("tickets", tickets);
        model.addAttribute("ticket", new Ticket());
        return "tickets/admin";
    }

    @PostMapping("/admin/attribuer")
    public String attribuerTicket(@RequestParam("dev") int idD, @RequestParam("ticket")int idT) {
        adminService.attribuerTicket(idD, idT);
        return "redirect:/admin";
    }

    @GetMapping("/client")
    public String Client(Model m) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Ticket> tickets= ticketRepository.getClientTicketsByUserName(username);
        m.addAttribute("tickets", tickets);
        m.addAttribute("ticket", new Ticket());
        return "tickets/client";
    }

    @PostMapping("/client/ajouter")
    public String ajouterTicket(@Valid Ticket ticket) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        Client c = clientRepository.getClientByUsername(username);
        ticket.setStatut("En cours");
        ticket.setClient(c);
        ticketRepository.save(ticket);
        return "redirect:/client";
    }

    @GetMapping("/dev")
    public String Developpeur(Model m) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Ticket> tickets= ticketRepository.getDeveloppeurTicketsByUserName(username);
        m.addAttribute("tickets", tickets);
        m.addAttribute("ticket", new Ticket());
        return "tickets/developpeur";
    }

    @PostMapping("/dev/miseajour")
    public String statutTicket(@RequestParam("statut") String statut, @RequestParam("ticket") int idT) {
        ticketRepository.statutTicket(idT, statut);
        return "redirect:/dev";
    }

}

