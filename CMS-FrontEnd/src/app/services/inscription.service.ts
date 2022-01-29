import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/internal/operators";
import { Inscription } from "src/app/models/model.inscription";
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' }
)
export class InscriptionService {
    httpOptions = {
        headers: new HttpHeaders(
            {
                'Content-Type': 'application/json',
                //'keyDB': environment.keyDB
            })
    };
    constructor(private http: HttpClient) {

    }

    saveInscription(inscription: Inscription): Observable<any> {
        let url = environment.host + '/accounts/SignUp';
        return this.http.post(url, inscription, this.httpOptions).pipe(
            catchError(
                err => throwError(err.error.message)
            )
        );
    }


}