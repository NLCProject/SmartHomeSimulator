import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-power-unit-overview',
  templateUrl: './power-unit-overview.component.html',
  styleUrls: ['./power-unit-overview.component.scss']
})
export class PowerUnitOverviewComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
