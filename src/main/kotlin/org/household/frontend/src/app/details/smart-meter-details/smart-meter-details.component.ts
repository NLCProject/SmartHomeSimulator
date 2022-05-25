import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-smart-meter-details',
  templateUrl: './smart-meter-details.component.html',
  styleUrls: ['./smart-meter-details.component.scss']
})
export class SmartMeterDetailsComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
