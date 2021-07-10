import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBusBookingComponent } from './add-bus-booking.component';

describe('AddBusBookingComponent', () => {
  let component: AddBusBookingComponent;
  let fixture: ComponentFixture<AddBusBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBusBookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBusBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
