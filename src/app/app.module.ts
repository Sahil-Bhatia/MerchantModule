import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';

import {FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import {Routes,RouterModule} from '@angular/router';
import { AddMerchantComponent } from './AddMerchantComponent/app.addMerchant';
import { GetAllMerchantComponent } from './GetAllMerchantComponent/app.getAllMerchant';


const routes:Routes=[
    { path:'',redirectTo:'list',pathMatch:'full'},
    { path:'add',component:AddMerchantComponent},
    { path:'list',component:GetAllMerchantComponent},
  ];
@NgModule({
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        RouterModule.forRoot(routes,{ onSameUrlNavigation: 'reload' })
        
    ],
    declarations: [
        AppComponent,
        AddMerchantComponent,
        GetAllMerchantComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }