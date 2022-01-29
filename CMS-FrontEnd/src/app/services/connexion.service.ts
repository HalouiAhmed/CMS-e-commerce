import { Jwt } from '../models/Jwt';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { Connexion } from "src/app/models/model.connexion";
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/internal/operators';


@Injectable({ providedIn: 'root' }
)
export class ConnexionService {


    httpOptions = {
        headers: new HttpHeaders(
            {
                'Content-Type': 'application/json',
                //'keyDB': environment.keyDB
            })
    };
    constructor(private http: HttpClient) { }

    setConnexion(connexion: Connexion): Observable<Jwt> {
        let url = environment.host + '/accounts/login';
        return this.http.post<Jwt>(url, connexion, this.httpOptions).pipe(
            catchError(
                err => {
                    if (err.error.status == 403) {
                        return throwError("email ou mot de passe incorrect")
                    }
                    else if (err.error.status == 500) {
                        return throwError("Erreur Interne")
                    }
                }
            )
        );
    }

    isLoggedIn() {
        let token = localStorage.getItem('jwt');
        if (token) {
            return true;
        }
        return false;
    }
}