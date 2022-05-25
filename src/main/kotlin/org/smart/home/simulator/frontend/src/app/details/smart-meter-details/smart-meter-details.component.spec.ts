import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartMeterDetailsComponent } from './smart-meter-details.component';

describe('SmartMeterDetailsComponent', () => {
  let component: SmartMeterDetailsComponent;
  let fixture: ComponentFixture<SmartMeterDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmartMeterDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartMeterDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
