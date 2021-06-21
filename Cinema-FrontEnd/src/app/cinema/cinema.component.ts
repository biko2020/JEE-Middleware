import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CinemaService} from "../services/cinema.service";

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit {

public villes :any;
public cinemas : any;
public salles: any;

public curentVille:any;
public curentCinema:any;


//imgFilm: any="http://localhost:8090/imageFilm/1"

  constructor(public cinemaservice:CinemaService) { }

  ngOnInit() {

    this.cinemaservice.getVilles()
      .subscribe(data => {
        this.villes = data;
      }, err => {
        console.log(err);
      })

  }

  onGetCinemas(ville:any) {
    this.curentVille=ville;
    this.cinemaservice.getCinemas(ville)
      .subscribe(data=> {
        this.cinemas = data;
      }, err=> {
        console.log(err);
      })
  }

  onGetSalles(cinema:any){
      this.curentCinema=cinema;
        this.cinemaservice.getSalles(cinema)
        .subscribe(data => {
          this.salles = data;
           this.salles._embedded.salles.forEach((salle:any)=>{
            this.cinemaservice.getProjections(salle)
             .subscribe(data=> {
               salle.projections = data;
             },err=>{
               console.log(err);
             })
          })
        },err=>{
          console.log(err);
        })
  }

  /*getImagesFilm(imgFilm:any){
        this.curentCinema=imgFilm;
        this.cinemaservice.getSalles(imgFilm)
        .subscribe(data => {
          this.salles = data;
           this.salles._embedded.projections.forEach((NumProject:any)=>{
           this.cinemaservice.getNameOfFilm(NumProject)
       .subscribe(data=> {
             NumProject.projections = data;
             },err=>{
               console.log(err);
             })
          })
        },err=>{
          console.log(err);
        })
  }*/

}
