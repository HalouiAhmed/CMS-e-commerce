import { SideBarItem } from '../../models/sidebarItem';
import { Component, ElementRef, Input, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from "@angular/common";
import { SidebarService } from 'src/app/services/sidebar.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  visible: any;
  sideBarItems: SideBarItem[];
  sortedItems: SideBarItem[];
  showFiller = false;
  @Input()
  logo: string;

  constructor(private router: Router, location: Location, private sidebarService: SidebarService) {
    router.events.subscribe(val => {
      if (location.path() == "/panier") this.visible = false;
      else this.visible = true;
    });
  }

  ngOnInit(): void {
    this.sidebarService.getSidebar().subscribe(
      result => {
        this.sideBarItems = result
        this.sortItems();
      }
    )
  }

  sortItems(): SideBarItem[] {
    this.sortedItems = new Array(this.sideBarItems.length);
    for (let item of this.sideBarItems) {
      this.sortedItems[item.position] = item;
    };
    return this.sortedItems;
  }

  isActive(url: string, exact: boolean): boolean {
    return this.router.isActive(url, exact);
  }

}
