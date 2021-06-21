package com.enset.service;

import com.enset.dao.*;
import com.enset.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service // en utilise la notation service pour la couche metier
@Transactional


public class CinemaInitServiceImplement implements IcinemaInitService {

    @Autowired // pour l injection des dependances
    private VilleRepo villeRepo; // en fait appel a l interface  villerepo
    @Autowired
    private CinemaRepo cinemaRepo;
    @Autowired
    private SalleRepo salleRepo;
    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private SeanceRepo seanceRepo;
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private ProjectionRepo projectionRepo;
    @Autowired
    private CategorieRepo categorieRepo;
    @Autowired
    private TicketRepo ticketRepo;


    @Override
    public void initVilles() {
        Stream.of("Casablanca","Rabat","Marrakech","Tanger").forEach(name_ville->{
            Ville ville = new Ville();
            ville.setName(name_ville);
            villeRepo.save(ville);

        });
    }



    @Override
    public void initCinemas() {
    villeRepo.findAll().forEach(ville->{
        Stream.of("MegaRama","IMAX","Founoun","Chahrazad","Daouliz")
                .forEach(namecinema->{
                    Cinema cinema = new Cinema();
                    cinema.setName_cinema(namecinema);
                    cinema.setNbr_salle(3+(int)(Math.random()*7));
                    cinema.setVille(ville);
                    cinemaRepo.save(cinema);
                });
    });

    }

    @Override
    public void initSalles() {

        cinemaRepo.findAll().forEach(cinema -> {
            for(int i=0; i<cinema.getNbr_salle();i++){
                Salle salle=new Salle();
                salle.setName_salle("Salle"+(i+1));
                salle.setCinema(cinema);
                salle.setNbr_place(15+(int)(Math.random()*20));
                salleRepo.save(salle);
            }
        });

    }

    @Override
    public void initPlaces() {

        salleRepo.findAll().forEach(salle->{
            for(int i=0;i<salle.getNbr_place();i++){
                Place place = new Place();
                place.setNum_salle(i+1);
                place.setSalle(salle);
                placeRepo.save(place);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(seance->{
            Seance sance = new Seance();
            try {
                sance.setHeureDebut(dateFormat.parse(seance));
                seanceRepo.save(sance);
            }catch (ParseException e){
                e.printStackTrace();
            }

        });
    }

    @Override
    public void initCategories() {
        Stream.of("Histories","Actions","Fiction","Drama").forEach(categorie->{
            Categorie catego = new Categorie();
            catego.setName_categorie(categorie);
            categorieRepo.save(catego);
        });

    }

    @Override
    public void initfilms() {
        double[] duree = new double[] {1,1.5,2,2.5,3};
        List<Categorie> categories=categorieRepo.findAll();
        Stream.of("Casablanca","break the silence", "geen book", "it s not my fault","le parrain","Seigneur des Anneaux").forEach(filmTitre->{
            Film film = new Film();
            film.setNom_film(filmTitre);
            film.setDurre_film(duree[new Random().nextInt(duree.length)]);
            film.setPhoto_film(filmTitre +".jpg");
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            filmRepo.save(film);
        });
    }

    @Override
    public void initProjections() {
  double[] price= new double[]{30,50,60,70,90,100};

  List<Film> films = filmRepo.findAll();
        villeRepo.findAll().forEach(ville->{
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    int index=new Random().nextInt(films.size());
                    Film film=films.get(index);
                            seanceRepo.findAll().forEach(seance -> {
                            ProjectionCin projection = new ProjectionCin();
                            projection.setPrix_projection(price[new Random().nextInt(price.length)]);
                            projection.setDat_projection(new Date());
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projection.setFilm(film);
                            projectionRepo.save(projection);

                        });
                });
            });
        });
    }

    @Override
    public void initTickets() {

        projectionRepo.findAll().forEach(project->{
            project.getSalle().getPlaces().forEach(place->{
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrix_ticket(project.getPrix_projection());
                ticket.setProjection(project);
                ticket.setReserve(0);
                ticketRepo.save(ticket);

            });
        });
    }

}
