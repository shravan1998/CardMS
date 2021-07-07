import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardMSServiceService {

  constructor(private http:HttpClient) { }

  addCC(id: string | null,Object: { cardNumber: any; nameOnCard: any; expiryDate: Date; }):Observable<any>{
    return this.http.post<any>("localhost:8000/card/add/"+id,Object);
  }
  viewCC(){

  }
  deleteCC(){

  }
}
