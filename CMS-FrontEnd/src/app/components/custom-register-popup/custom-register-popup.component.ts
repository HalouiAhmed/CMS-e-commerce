import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Inscription } from 'src/app/models/model.inscription';
import { InscriptionService } from 'src/app/services/inscription.service';
import { ErrorStateMatcher } from '@angular/material/core';
import { FormGroupDirective, NgForm } from '@angular/forms';
import { ConnexionService } from 'src/app/services/connexion.service';
import { Connexion } from 'src/app/models/model.connexion';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custom-register-popup',
  templateUrl: './custom-register-popup.component.html',
  styleUrls: ['./custom-register-popup.component.css']
})
export class CustomRegisterPopupComponent implements OnInit {

  inscription: Inscription = new Inscription();
  connexion: Connexion = new Connexion;
  hidePassword: boolean = true;
  hideRepeatPassword: boolean = true;
  loading: boolean = false;
  matcher = new MyErrorStateMatcher()
  registerForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    password: new FormControl('', [Validators.required,
    Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]),
    repeatPassword: new FormControl('', [Validators.required]),
    adresse: new FormControl('', Validators.required),
    tel: new FormControl('', [Validators.required, Validators.maxLength(10)]),
    acceptCGU: new FormControl('', Validators.required)
  });
  constructor(private inscriptionService: InscriptionService,
    private connexionSerive: ConnexionService, private _snackBar: MatSnackBar,
    private dialogRef: MatDialogRef<CustomRegisterPopupComponent>,
    private router: Router,) { }

  ngOnInit(): void {
  }
  get firstName() { return this.registerForm.get('firstName'); }
  get lastName() { return this.registerForm.get('lastName'); }
  get email() { return this.registerForm.get('email'); }
  get password() { return this.registerForm.get('password'); }
  get repeatPassword() { return this.registerForm.get('repeatPassword'); }
  get adresse() { return this.registerForm.get('adresse'); }
  get tel() { return this.registerForm.get('tel'); }
  get acceptCGU() { return this.registerForm.get('acceptCGU'); }

  onSubmit() {
    this.loading = true;
    this.inscription.firstName = this.firstName.value;
    this.inscription.lastName = this.lastName.value;
    this.inscription.email = this.email.value;
    this.inscription.adresse = this.adresse.value;
    this.inscription.password = this.password.value;
    this.inscription.tel = this.tel.value;
    this.inscriptionService.saveInscription(this.inscription).subscribe(
      result => {
        this.connexion.login = this.email.value;
        this.connexion.password = this.password.value;
        this.connexionSerive.setConnexion(this.connexion).subscribe(
          result => {
            localStorage.setItem('jwt', result.jwt);
            this.router.navigate(['/panier']);
            this.dialogRef.close();
          }
        )
        this.loading = false;
      },
      error => {
        this.loading = false;
        this.openSnackBar(error, "Erreur")
      }
    )
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 5000,
      panelClass: ['snackbar'],
    });
  }

  isPasswordConfirmationValid(): boolean {
    const password = this.password.value;
    const confirmPassword = this.repeatPassword.value;
    return password === confirmPassword ? true : false
  }
}

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    const password = form.form.get('password').value;
    const confirmPassword = form.form.get('repeatPassword').value;
    return !!(((password != confirmPassword) && (control.dirty || control.touched)) || control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
