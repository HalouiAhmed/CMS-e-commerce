import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ContactUsForm } from 'src/app/models/contactus.form.model';
import { ContactUsParagraph } from 'src/app/models/contactus.paragraph';
import { ContactUsService } from 'src/app/services/contactus.service';

@Component({
  selector: 'app-contactus',
  templateUrl: './contactus.component.html',
  styleUrls: ['./contactus.component.css']
})
export class ContactusComponent implements OnInit {
  contactusParag : ContactUsParagraph = new ContactUsParagraph();
  contactusForm: ContactUsForm = new ContactUsForm();
  loading: boolean = false;
  contactForm = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.email, Validators.required]),
    phone: new FormControl('', [Validators.required, Validators.maxLength(10)]),
    message: new FormControl('', Validators.required),
  });
  constructor(private contactusService: ContactUsService) { }

  ngOnInit(): void {
    this.contactusService.getContactUsParag().subscribe(
      result => this.contactusParag = result
    )
  }
  get name() { return this.contactForm.get('name'); }
  get email() { return this.contactForm.get('email'); }
  get phone() { return this.contactForm.get('phone'); }
  get message() { return this.contactForm.get('message'); }

  onSubmit() {
    this.loading = true;
    this.contactusForm.name = this.name.value;
    this.contactusForm.email = this.email.value;
    this.contactusForm.phone = this.phone.value;
    this.contactusForm.message = this.message.value;
    this.contactusService.sendContactUsForm(this.contactusForm).subscribe();
  }
}
