import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerUnitOverviewComponent } from './power-unit-overview.component';

describe('PowerUnitOverviewComponent', () => {
  let component: PowerUnitOverviewComponent;
  let fixture: ComponentFixture<PowerUnitOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerUnitOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerUnitOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
