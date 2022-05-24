import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-power-charger-overview',
  templateUrl: './power-charger-overview.component.html',
  styleUrls: ['./power-charger-overview.component.scss']
})
export class PowerChargerOverviewComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
