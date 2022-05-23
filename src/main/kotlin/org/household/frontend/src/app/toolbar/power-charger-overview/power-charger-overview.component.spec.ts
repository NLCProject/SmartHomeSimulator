import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerChargerOverviewComponent } from './power-charger-overview.component';

describe('PowerChargerOverviewComponent', () => {
  let component: PowerChargerOverviewComponent;
  let fixture: ComponentFixture<PowerChargerOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerChargerOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerChargerOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
