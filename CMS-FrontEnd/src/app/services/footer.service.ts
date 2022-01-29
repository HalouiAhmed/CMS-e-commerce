import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FooterItem } from "src/app/models/footer.model";
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' }
)
export class FooterService {
    constructor(private http: HttpClient) {

    }
    getFooter(): Observable<FooterItem[]> {
        let url = environment.host + '/footer';
        return this.http.get<FooterItem[]>(url);

    }
}