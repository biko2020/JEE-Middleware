import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit {

public villes ;

  constructor(private http:HttpClient) { }

  ngOnInit(){

    this.http.get("http://localhost:8090/villes")
      .subscribe(data=>{
        this.villes=data;
      },err=>{
        console.log(err);
      })
  }

}
