import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerStorageOverviewComponent } from './power-storage-overview.component';

describe('PowerStorageOverviewComponent', () => {
  let component: PowerStorageOverviewComponent;
  let fixture: ComponentFixture<PowerStorageOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerStorageOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PowerStorageOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
