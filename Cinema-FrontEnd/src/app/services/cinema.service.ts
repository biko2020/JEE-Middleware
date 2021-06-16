import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  public host:string="http://localhost:8090"


  constructor(private http:HttpClient) { }

  public getVilles(){
 return this.http.get(this.host+"/villes");
  }

  getCinemas(ville:any){
   return this.http.get(ville._links.cinemas.href);
  }

  getSalles(cinema:any){
    return this.http.get(cinema._links.salles.href);
  }

  getProjections(salle:any){
    let url = salle._links.projections.href.replace("{?projection}","");
    return this.http.get(url+"?projection=p1");
  }

  getNameOfFilm(imgFilm:any){
     return this.http.get("http://localhost:8090/imageFilm/+'imgFilm'+");
  }

}
