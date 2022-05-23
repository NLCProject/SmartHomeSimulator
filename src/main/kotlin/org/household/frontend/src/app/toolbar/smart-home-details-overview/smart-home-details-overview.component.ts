import { Component, OnInit } from '@angular/core';
import { I18nKey } from 'src/app/models/I18nKey';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-smart-home-details-overview',
  templateUrl: './smart-home-details-overview.component.html',
  styleUrls: ['./smart-home-details-overview.component.scss']
})
export class SmartHomeDetailsOverviewComponent implements OnInit {

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.selectedTab = +JSON.parse(this.route.snapshot.paramMap.get('index'));
  }

  public I18nKey = I18nKey;
  public selectedTab = 0;
  private swipeCoordinate: [number, number];
  private swipeTime = 0;
  private numberTabs = 6;

  public swipe(event: TouchEvent, when: string): void {
    const coordinate: [number, number] = [event.changedTouches[0].clientX, event.changedTouches[0].clientY];
    const time = new Date().getTime();

    if (when === 'start') {
      this.swipeCoordinate = coordinate;
      this.swipeTime = time;
    } else if (when === 'end') {
      const direction = [coordinate[0] - this.swipeCoordinate[0], coordinate[1] - this.swipeCoordinate[1]];
      const duration = time - this.swipeTime;

      if (
        duration < 1000 // Long enough
        && Math.abs(direction[0]) > 30 // Long enough
        && Math.abs(direction[0]) > Math.abs(direction[1] * 3) // Horizontal enough
      ) {
        const swipe = direction[0] < 0 ? 'next' : 'previous';
        if (swipe === 'next') {
          if (this.selectedTab < this.numberTabs - 1) {
            this.selectedTab += 1;
          } else {
            this.selectedTab = 0;
          }
        } else if (swipe === 'previous') {
          if (this.selectedTab === 0) {
            this.selectedTab = this.numberTabs - 1;
          } else {
            this.selectedTab -= 1;
          }
        }
      }
    }
  }
}
