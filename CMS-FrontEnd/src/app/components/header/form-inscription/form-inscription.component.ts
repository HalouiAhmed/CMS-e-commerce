import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Inscription } from 'src/models/model.inscription';
import { InscriptionService } from 'src/services/inscription.service';
import {ConfirmedValidator} from './mustMatch';

@Component({
  selector: 'app-form-inscription',
  templateUrl: './form-inscription.component.html',
  styleUrls: ['./form-inscription.component.css']
})
export class FormInscriptionComponent implements OnInit {
  inscription: Inscription;
  inscriptionResponse: Inscription;
  fieldTextType: boolean;
  repeateTextType: boolean;
  form_inscription = new FormGroup({});
  constructor(private inscriptionService: InscriptionService,formBuilder: FormBuilder) {
    this.form_inscription= formBuilder.group({
      firstName: new FormControl('', Validators.required),
      lastName:new FormControl('', Validators.required),
      email: new FormControl('',[Validators.email, Validators.required]),
      password:new FormControl('',[Validators.required,Validators.minLength(8)]),
      confirm_mot_de_passe: new FormControl('',Validators.required),
      cb: new FormControl(false, Validators.requiredTrue),
    }, {
      validator: ConfirmedValidator('mot_de_passe', 'confirm_mot_de_passe')

    })
  }

  onSubmit(){
    this.inscription = this.form_inscription.value;
    this.inscription.tel = "1234";
    this.inscription.adresse = "effyis";
    this.inscriptionService.saveInscription(this.inscription).subscribe(
      res => {
        this.inscriptionResponse = res;
      }
    );

  }


  ngOnInit(): void {
  }
  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;

  }
  toggleRepeateFieldTextType() {
    this.repeateTextType = !this.repeateTextType;

  }

  }
