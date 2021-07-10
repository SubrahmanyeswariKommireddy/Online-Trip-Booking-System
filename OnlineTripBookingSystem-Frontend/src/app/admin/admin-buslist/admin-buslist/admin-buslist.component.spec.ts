import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBuslistComponent } from './admin-buslist.component';

describe('AdminBuslistComponent', () => {
  let component: AdminBuslistComponent;
  let fixture: ComponentFixture<AdminBuslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminBuslistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBuslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
