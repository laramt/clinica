import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacientListComponent } from './pacient-list/pacient-list.component';
import { CreatePacientComponent } from './create-pacient/create-pacient.component';
import { UpdatePacientComponent } from './update-pacient/update-pacient.component';
import { PacientDetailsComponent } from './pacient-details/pacient-details.component';


@NgModule({
  declarations: [
    AppComponent,
    PacientListComponent,
    CreatePacientComponent,
    UpdatePacientComponent,
    PacientDetailsComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
