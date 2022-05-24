import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-power-storage-overview',
  templateUrl: './power-storage-overview.component.html',
  styleUrls: ['./power-storage-overview.component.scss']
})
export class PowerStorageOverviewComponent implements OnInit {

  constructor() { }

  @Input()
  public smartHomeId: string;

  ngOnInit(): void {
  }

}
