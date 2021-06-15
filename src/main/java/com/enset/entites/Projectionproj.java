package com.enset.entites;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name="p1",types={com.enset.entites.Projection.class})
public interface Projectionproj {

   public Long getid_projection();
   public  double getprix_projection();
   public Date getdat_projection();
   public Salle getSalle();
   public Film getFilm();
   public Seance getSeance();
   public Collection<Ticket> getTickets();


}
