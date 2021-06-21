package com.enset.entites;


import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Date;

@CrossOrigin("*")

@Projection(name="p1",types={ProjectionCin.class})
public interface Projectionproj {

   public Long getId_projection();
   public  double getPrix_projection();
   public Date getDat_projection();
   public Salle getSalle();
   public Film  getFilm();
   public Seance getSeance();
   public Collection<Ticket> getTickets();

}
