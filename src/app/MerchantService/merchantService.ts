import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Merchant } from '../MerchantModel/Merchant';


@Injectable({
  providedIn: 'root'
})
export class MerchantService {
 private URL:string = "http://localhost:5000/merchant/";
  constructor(private http:HttpClient) { }


findByEmail(email:String):Observable<any>{
 
    return this.http.get(URL+"find/"+email);
}


getAllMerchantsList():Observable<any>{
  return this.http.get(this.URL);
}

addNewMerchant(data:Merchant):Observable<any>{
  let options = { "headers": 
              new HttpHeaders({ "Content-Type": "application/json" }) };
              return this.http.post(this.URL+"new/",data,options);
              
}
deleteMerchant(merchantId:number):Observable<any>{
  console.log("In service delete"+merchantId)
   return this.http.delete(this.URL+"delete/"+merchantId);
}


updateMerchantDetails(data:Merchant):Observable<any>{
  let options = { "headers": 
  new HttpHeaders({ "Content-Type": "application/json" }) };

   return this.http.put(this.URL+"update",data,options);
}







}
