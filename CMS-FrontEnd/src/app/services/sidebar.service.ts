import { SideBarItem } from '../models/sidebarItem';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SidebarService {

  constructor(private http: HttpClient) { }

  getSidebar(): Observable<SideBarItem[]> {
    let url = environment.host + '/sidebar';
    return this.http.get<SideBarItem[]>(url);
  }
}
