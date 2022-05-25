import {Component, Input} from '@angular/core';
import {PowerStorageService} from "../../services/power-storage.service";

@Component({
  selector: 'app-power-storage-overview',
  templateUrl: './power-storage-overview.component.html',
  styleUrls: ['./power-storage-overview.component.scss']
})
export class PowerStorageOverviewComponent {

  constructor(
      public service: PowerStorageService
  ) { }

  @Input()
  public smartHomeId: string;

  public getSmartHomeId(): string {
    return this.smartHomeId;
  }
}