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



  constructor(private cinemaservice:CinemaService) { }

  ngOnInit() {

    this.cinemaservice.getVilles()
      .subscribe(data => {
        this.villes = data;
      }, err => {
        console.log(err);
      })

  }

  onGetCinemas(ville: any) {
    this.cinemaservice.getCinemas(ville)
      .subscribe(data=> {
        this.cinemas = data;
      }, err=> {
        console.log(err);
      })
  }
}
