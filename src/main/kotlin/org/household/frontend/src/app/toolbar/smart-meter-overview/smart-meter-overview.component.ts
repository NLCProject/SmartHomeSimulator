import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-smart-meter-overview',
  templateUrl: './smart-meter-overview.component.html',
  styleUrls: ['./smart-meter-overview.component.scss']
})
export class SmartMeterOverviewComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
