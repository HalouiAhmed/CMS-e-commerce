import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Connexion } from 'src/app/models/model.connexion';
import { ConnexionService } from 'src/app/services/connexion.service';

@Component({
  selector: 'app-custom-login-popup',
  templateUrl: './custom-login-popup.component.html',
  styleUrls: ['./custom-login-popup.component.css']
})
export class CustomLoginPopupComponent implements OnInit {

  connexion: Connexion = new Connexion();
  mode: string = ""
  hide: boolean = true;
  loading: boolean = false;
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.required]),
    password: new FormControl('', Validators.required),
  });

  constructor(private connexionService: ConnexionService,
    private _snackBar: MatSnackBar, private router: Router,
    private dialogRef: MatDialogRef<CustomLoginPopupComponent>) { }

  ngOnInit(): void {
  }
  get password() { return this.loginForm.get('password'); }
  get email() { return this.loginForm.get('email'); }

  onSubmit() {
    this.mode = "indeterminate";
    this.loading = true;
    this.connexion.login = this.email.value;
    this.connexion.password = this.password.value;
    this.connexionService.setConnexion(this.connexion).subscribe(
      result => {
        localStorage.setItem('jwt', result.jwt);
        this.mode = "";
        this.loading = false;
        this.router.navigate(['/panier']);
        this.dialogRef.close();
      },
      error => {
        this.mode = "";
        this.loading = false;
        this.openSnackBar(error, "Erreur")
      }
    );
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 5000,
      panelClass: ['snackbar'],
    });
  }

}
