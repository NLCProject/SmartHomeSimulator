import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectricalDeviceDetailsComponent } from './electrical-device-details.component';

describe('ElectricalDeviceDetailsComponent', () => {
  let component: ElectricalDeviceDetailsComponent;
  let fixture: ComponentFixture<ElectricalDeviceDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElectricalDeviceDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ElectricalDeviceDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
