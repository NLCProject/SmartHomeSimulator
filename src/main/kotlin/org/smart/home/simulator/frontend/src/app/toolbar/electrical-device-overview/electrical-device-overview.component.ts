import {Component, Input} from '@angular/core';
import {ElectricalDeviceService} from '../../services/electrical-device.service';

@Component({
  selector: 'app-electrical-device-overview',
  templateUrl: './electrical-device-overview.component.html',
  styleUrls: ['./electrical-device-overview.component.scss']
})
export class ElectricalDeviceOverviewComponent {

  constructor(
      public service: ElectricalDeviceService
  ) { }

  @Input()
  public smartHomeId: string;

  public getSmartHomeId(): string {
    return this.smartHomeId;
  }
}
