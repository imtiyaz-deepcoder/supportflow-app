package com.deepcoder.supportflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepcoder.supportflow.model.Ticket;
import com.deepcoder.supportflow.service.TicketService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController { // take i/p give o/p

    @Autowired
    private TicketService ticketService;

    @PostMapping("/api/ticket")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/api/ticket")
    public List<Ticket> getAllTickets() { // T1 T2 T3
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/api/ticket/{id}") // <-- path variable
    public void deleteTicket(@PathVariable("id") long id) {
        ticketService.deleteTicket(id);
    }

    // id :- new Ticket
    @PutMapping("/api/ticket/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable("id") long id,
            @RequestBody Ticket newTicket) {
        // validate id
        try {
            Ticket dbTicket = ticketService.validateId(id);
            // attach newTicket to existing Ticket values in Db
            dbTicket.setSubject(newTicket.getSubject());
            dbTicket.setDescription(newTicket.getDescription());
            dbTicket.setPriority(newTicket.getPriority());
            dbTicket.setStatus(newTicket.getStatus());
            // save ticke again in db
            return ResponseEntity.ok().body(ticketService.addTicket(dbTicket));

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
// java obj = json <-- Jackson