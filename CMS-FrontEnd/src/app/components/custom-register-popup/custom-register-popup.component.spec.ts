import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomRegisterPopupComponent } from './custom-register-popup.component';

describe('CustomRegisterPopupComponent', () => {
  let component: CustomRegisterPopupComponent;
  let fixture: ComponentFixture<CustomRegisterPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomRegisterPopupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomRegisterPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
