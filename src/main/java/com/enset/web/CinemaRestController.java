package com.enset.web;

import com.enset.dao.FilmRepo;
import com.enset.dao.TicketRepo;
import com.enset.entites.Film;
import com.enset.entites.Ticket;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController()

public class CinemaRestController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping(path = "/imageFilm/{id_film}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name = "id_film") Long id_film) throws Exception {
        Film flm = filmRepo.getById(id_film);
        String photoName = flm.getPhoto_film();
        File file = new File(System.getProperty("user.home") + "/cinema/images/" + photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    final String url ="myTicket";

    @PostMapping(value=url)
    @Transactional

    /**--- info about ticket ---***/
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm)
    {
        List<Ticket> listTickets = new ArrayList<>();
        ticketForm.getTickets().forEach(id_ticket->{
            Ticket ticket = ticketRepo.findById(id_ticket).get();
            ticket.setNom_client(ticketForm.getNomClient());
            ticket.setCodepayment_ticket(ticketForm.getCodePayement());
            ticket.setReserve(1);
            ticketRepo.save(ticket);
            listTickets.add(ticket);
        });

        return listTickets;
    }

}

@Data
    class TicketForm
    {
        private String nomClient;
        private int codePayement;
        private List<Long> tickets = new ArrayList<>();
    }

