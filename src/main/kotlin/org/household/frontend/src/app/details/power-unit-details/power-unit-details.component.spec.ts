import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerUnitDetailsComponent } from './power-unit-details.component';

describe('PowerUnitDetailsComponent', () => {
  let component: PowerUnitDetailsComponent;
  let fixture: ComponentFixture<PowerUnitDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerUnitDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerUnitDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
