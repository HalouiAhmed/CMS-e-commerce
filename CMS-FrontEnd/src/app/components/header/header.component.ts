import { Component, ElementRef, HostListener, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CustomLoginPopupComponent } from '../custom-login-popup/custom-login-popup.component';
import { ThemeService } from 'src/app/theme/theme.service';
import { CustomRegisterPopupComponent } from '../custom-register-popup/custom-register-popup.component';
import { ConnexionService } from 'src/app/services/connexion.service';
import { SidebarService } from 'src/app/services/sidebar.service';
import { SideBarItem } from 'src/app/models/sidebarItem';
import { Router } from '@angular/router';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  @Output()
  toggle: EventEmitter<boolean> = new EventEmitter<boolean>();
  showSideBar = false;
  show: boolean = false;
  sideBarItems: SideBarItem[];
  constructor(public dialog: MatDialog, private themeService: ThemeService,
    public connexionService: ConnexionService,
    private sidebarService: SidebarService, private router: Router,
    private eRef: ElementRef) { }
  @HostListener('document:click', ['$event'])
  clickout(event) {
    if (this.eRef.nativeElement.contains(event.target)) {

    } else {
      this.show = false;
    }
  }
  ngOnInit() {
    this.sidebarService.getSidebar().subscribe(
      result => {
        this.sideBarItems = result
      }
    )
  };

  goTo(url) {
    this.router.navigate([url]);
    this.show = false;
  }

  onFocus() {
    this.show = true;
  }


  toggleTheme() {
    if (this.themeService.isDarkTheme()) {
      this.themeService.setLightTheme();
    } else {
      this.themeService.setDarkTheme();
    }
  }

  openDialog(type) {
    if (type == 'c') {
      this.dialog.open(CustomLoginPopupComponent);
    }
    else if (type == 's') {
      this.dialog.open(CustomRegisterPopupComponent);
    }
  }

  sidebarToggle() {
    this.showSideBar = !this.showSideBar;
    this.toggle.emit(this.showSideBar);
  }

}
