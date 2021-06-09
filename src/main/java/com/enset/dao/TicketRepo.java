package com.enset.dao;

import com.enset.entites.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepo extends JpaRepository<Ticket, Long> {


}
