import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectricalDeviceOverviewComponent } from './electrical-device-overview.component';

describe('ElectricalDeviceOverviewComponent', () => {
  let component: ElectricalDeviceOverviewComponent;
  let fixture: ComponentFixture<ElectricalDeviceOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElectricalDeviceOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElectricalDeviceOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
