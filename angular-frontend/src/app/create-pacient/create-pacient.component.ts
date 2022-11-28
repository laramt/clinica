import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Pacient } from '../pacient';
import { PacientService } from '../pacient.service';

@Component({
  selector: 'app-create-pacient',
  templateUrl: './create-pacient.component.html',
  styleUrls: ['./create-pacient.component.css']
})
export class CreatePacientComponent {

  pacient: Pacient = new Pacient;
  constructor(private pacientService: PacientService,
   private router: Router ){ }

  ngOnInit(): void {
  }

  goToPacientList(){
    this.router.navigate(['/pacients']);
  }

  savePacient(){
    this.pacientService.creatPacient(this.pacient).subscribe (data => {
      console.log(data);
      this.goToPacientList();
    },
    error => console.log(error));
  }

  onSubmit(){
    console.log(this.pacient);
    this.savePacient();
  }

}
