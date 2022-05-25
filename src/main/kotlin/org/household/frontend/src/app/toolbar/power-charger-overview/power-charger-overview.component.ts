import {Component, Input} from '@angular/core';
import {PowerChargerService} from '../../services/power-charger.service';

@Component({
  selector: 'app-power-charger-overview',
  templateUrl: './power-charger-overview.component.html',
  styleUrls: ['./power-charger-overview.component.scss']
})
export class PowerChargerOverviewComponent {

  constructor(
      public service: PowerChargerService
  ) { }

  @Input()
  public smartHomeId: string;

  public getSmartHomeId(): string {
    return this.smartHomeId;
  }
}
