import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import {MerchantService} from '../MerchantService/merchantService'
import { Merchant } from '../MerchantModel/Merchant';

@Component({
  selector: 'app-add-merchant',
  templateUrl: './app.addMerchant.html'
})
export class AddMerchantComponent implements OnInit {


  constructor(private service: MerchantService, private router: Router) {
   
  }

  ngOnInit() {
  }


  
  merchantId:number
  firstName:String
  lastName:String
  company:String
  emailid:String
  mobileno:number
  password:String
  photo:String
  rating:number
  check:boolean=false;
  messageResponse:string;
  status: string="Dis-Approved";


  onSelectFile(files: FileList){
    if (files.item[0]!=null) {
      var reader = new FileReader();

     reader.readAsDataURL(files.item[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        this.photo = null;
      }
    }
  }
  addMerchant(): any {
    
    var ob: any = new Merchant(null,this.firstName,this.lastName,this.company,
      this.emailid,this.mobileno,this.password,this.photo,this.rating,this.status);
    this.service.addNewMerchant(ob).subscribe(data => {
      console.log(data);
      this.messageResponse=data.message+"\n"+"Status Code: "+data.statusCode+"\n";
      alert(this.messageResponse);
    })

    //clearing values
  this.merchantId=null
  this.firstName=null
  this.lastName=null
  this.company=null
  this.emailid=null
  this.mobileno=null
  this.password=null
  this.photo=null
  this.rating=null
  this.check=false
    

    }

      
  
  onCheckboxValueChange():any{
    this.check=!this.check
    if(this.check){
    this.status="Approved";
    alert(this.status)  
    }
    else{
    this.status="Dis-Approved";
    alert(this.status)  
    }
  }
  }

