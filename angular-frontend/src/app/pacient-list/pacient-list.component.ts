import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Pacient } from '../pacient';
import { PacientService } from '../pacient.service';

@Component({
  selector: 'app-pacient-list',
  templateUrl: './pacient-list.component.html',
  styleUrls: ['./pacient-list.component.css']
})
export class PacientListComponent {

pacients!: Pacient[];

constructor(private pacientService: PacientService, private router: Router){ }

 ngOnInit(): void{
  this.getPacients();
}

private getPacients(){
  
  this.pacientService.getPacientsList().subscribe(data => {
    this.pacients = data;
  });
} 
updatePacient(id: number){
 this.router.navigate(['update-pacient', id]);
}

deletePacient(id: number){
 this.pacientService.deletePacient(id).subscribe(data => {
  console.log(data);
  this.getPacients();
 });
}

pacientDetails(id: number){
  this.router.navigate(['pacient-details', id]);
}

}
