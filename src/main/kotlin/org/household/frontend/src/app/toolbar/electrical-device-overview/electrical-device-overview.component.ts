import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-electrical-device-overview',
  templateUrl: './electrical-device-overview.component.html',
  styleUrls: ['./electrical-device-overview.component.scss']
})
export class ElectricalDeviceOverviewComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
