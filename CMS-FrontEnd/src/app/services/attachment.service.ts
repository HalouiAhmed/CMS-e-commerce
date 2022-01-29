import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Attachment } from '../models/attachment';

@Injectable({
  providedIn: 'root'
})
export class AttachmentService {

  httpOptions = {
    headers: new HttpHeaders(
      {
        'Content-Type': 'application/json',
        //'keyDB': environment.keyDB
      })
  };
  constructor(private http: HttpClient) { }

  getLogo(): Observable<Attachment> {
    let url = environment.host + '/attachement/get/' + 1;
    return this.http.get<Attachment>(url, this.httpOptions);
  }

}
