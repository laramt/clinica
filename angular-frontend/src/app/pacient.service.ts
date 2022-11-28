import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pacient } from './pacient';

@Injectable({
  providedIn: 'root'
})
export class PacientService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/clinica/pacients';
  }

   getPacientsList(): Observable<Pacient[]> {
    return this.http.get<Pacient[]>(`${this.baseUrl}`);
  }

   creatPacient(pacient: Pacient): Observable<Object>{
    return this.http.post(`${this.baseUrl}`, pacient);
  }

    getPacientById(id: number): Observable<Pacient>{
      return this.http.get<Pacient>(`${this.baseUrl}/${id}`);
    }

    updatePacient(id: number, pacient: Pacient): Observable<Object>{
      return this.http.put(`${this.baseUrl}/${id}`, pacient);
    }

    deletePacient(id: number): Observable<Object>{
      return this.http.delete(`${this.baseUrl}/${id}`);
    }
}
