import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerChargerDetailsComponent } from './power-charger-details.component';

describe('PowerChargerDetailsComponent', () => {
  let component: PowerChargerDetailsComponent;
  let fixture: ComponentFixture<PowerChargerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerChargerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerChargerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
