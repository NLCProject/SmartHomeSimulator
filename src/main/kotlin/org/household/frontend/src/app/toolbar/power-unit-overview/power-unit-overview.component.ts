import {Component, Input} from '@angular/core';
import {PowerUnitService} from '../../services/power-unit.service';

@Component({
  selector: 'app-power-unit-overview',
  templateUrl: './power-unit-overview.component.html',
  styleUrls: ['./power-unit-overview.component.scss']
})
export class PowerUnitOverviewComponent {

  constructor(
      public service: PowerUnitService
  ) { }

  @Input()
  public smartHomeId: string;

  public getSmartHomeId(): string {
    return this.smartHomeId;
  }
}
