import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pacient } from '../pacient';
import { PacientService } from '../pacient.service';

@Component({
  selector: 'app-pacient-details',
  templateUrl: './pacient-details.component.html',
  styleUrls: ['./pacient-details.component.css']
})
export class PacientDetailsComponent  implements OnInit{

  id!: number
  pacient!: Pacient
  constructor(private route: ActivatedRoute, private employeService: PacientService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.pacient = new Pacient();
    this.employeService.getPacientById(this.id).subscribe( data => {
      this.pacient = data;
    });

}
}
