import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/internal/operators";
import { environment } from "src/environments/environment";
import { ContactUsForm } from "../models/contactus.form.model";
import { ContactUsParagraph } from "../models/contactus.paragraph";

@Injectable({ providedIn: 'root' }
)
export class ContactUsService {


    httpOptions = {
        headers: new HttpHeaders(
            {
                'Content-Type': 'application/json',
            })
    };
    constructor(private http: HttpClient) { }

    sendContactUsForm(contactus: ContactUsForm) {
        let url = environment.host + '/contactus';
        return this.http.post(url, contactus, this.httpOptions).pipe(
            catchError(
                err => {
                    if (err.error.status == 500) {
                        return throwError("Erreur Interne")
                    }
                    else if(err.error.status ==402){
                        return throwError("Bad request!")
                    }
                }
            )
        );
    }
    getContactUsParag(): Observable<ContactUsParagraph> {
        let url = environment.host + '/contactUs';
        return this.http.get<ContactUsParagraph>(url);

    }

}