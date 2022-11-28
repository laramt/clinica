import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Pacient } from '../pacient';
import { PacientService } from '../pacient.service';

@Component({
  selector: 'app-update-pacient',
  templateUrl: './update-pacient.component.html',
  styleUrls: ['./update-pacient.component.css']
})
export class UpdatePacientComponent implements OnInit{

  id!: number;
  pacient: Pacient = new Pacient();
  constructor(private pacientService: PacientService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit(): void{
      this.id = this.route.snapshot.params['id'];
      this.pacientService.getPacientById(this.id).subscribe(data => {
        this.pacient = data;},
        error => console.log(error));
  }

  onSubmit(){
    this.pacientService.updatePacient(this.id, this.pacient).subscribe( data => {
      this.goToPacientList(); },
      
      error => console.log(error));
  }

  goToPacientList(){
    this.router.navigate(['/pacients']);
  }
}
