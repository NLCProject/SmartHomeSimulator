import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerStorageDetailsComponent } from './power-storage-details.component';

describe('PowerStorageDetailsComponent', () => {
  let component: PowerStorageDetailsComponent;
  let fixture: ComponentFixture<PowerStorageDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerStorageDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerStorageDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
