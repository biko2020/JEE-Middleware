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




  constructor(private cinemaservice:CinemaService) { }

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
          this.salles._embedded.salles.forEach()
        },err=>{
          console.log(err);
        })
  }
}
