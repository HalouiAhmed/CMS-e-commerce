import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FooterItem } from 'src/app/models/footer.model';
import { FooterService } from 'src/app/services/footer.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  footer: FooterItem[];
  subscriptionForm = new FormGroup({
    email: new FormControl('', Validators.email),
  });

  constructor(private footerService: FooterService) { }

  ngOnInit(): void {
    this.footerService.getFooter().subscribe(
      result => this.footer = result
    );
  }

  get email() { return this.subscriptionForm.get('email'); }

  onSubmit() {

  }

}
