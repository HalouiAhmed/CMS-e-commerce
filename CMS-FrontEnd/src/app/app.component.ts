import { Component, OnInit } from '@angular/core';
import { Attachment } from './models/attachment';
import { AttachmentService } from './services/attachment.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontcms';
  toggle: boolean;
  attachment: Attachment = new Attachment;
  logo: string = "https://effyoup.com/wp-content/uploads/2020/11/effyis-logo-new-white.png";

  constructor(private attachmentService: AttachmentService) { }

  ngOnInit(): void {
    this.attachmentService.getLogo().subscribe(
      result => {
        this.attachment = result;
        this.logo = this.attachment.cloudinaryInformationList[this.attachment.activeAttachement].secure_url;
      }
    );
  }

  toggleSidebar(event) {
    this.toggle = event;
  }
}

