import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartMeterOverviewComponent } from './smart-meter-overview.component';

describe('SmartMeterOverviewComponent', () => {
  let component: SmartMeterOverviewComponent;
  let fixture: ComponentFixture<SmartMeterOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmartMeterOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartMeterOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
