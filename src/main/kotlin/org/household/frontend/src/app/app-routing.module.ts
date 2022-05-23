import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ElectricalDeviceDetailsComponent} from './details/electrical-device-details/electrical-device-details.component';
import {PowerChargerDetailsComponent} from './details/power-charger-details/power-charger-details.component';
import {PowerStorageDetailsComponent} from './details/power-storage-details/power-storage-details.component';
import {PowerUnitDetailsComponent} from './details/power-unit-details/power-unit-details.component';
import {SmartHomeDetailsComponent} from './toolbar/smart-home-details/smart-home-details.component';
import {SmartMeterDetailsComponent} from './details/smart-meter-details/smart-meter-details.component';
import {SmartHomeOverviewComponent} from "./toolbar/smart-home-overview/smart-home-overview.component";
import {SmartHomeDetailsOverviewComponent} from "./toolbar/smart-home-details-overview/smart-home-details-overview.component";

const routes: Routes = [
  {
    path: 'electrical-device/details/:id',
    component: ElectricalDeviceDetailsComponent
  }, {
    path: 'power-charger/details/:id',
    component: PowerChargerDetailsComponent
  }, {
    path: 'power-storage/details/:id',
    component: PowerStorageDetailsComponent
  }, {
    path: 'power-unit/details/:id',
    component: PowerUnitDetailsComponent
  }, {
    path: 'smart-home/details/:id',
    component: SmartHomeDetailsOverviewComponent
  }, {
    path: 'smart-meter/details/:id',
    component: SmartMeterDetailsComponent
  },   {
    path: 'electrical-device/details',
    component: ElectricalDeviceDetailsComponent
  }, {
    path: 'power-charger/details',
    component: PowerChargerDetailsComponent
  }, {
    path: 'power-storage/details',
    component: PowerStorageDetailsComponent
  }, {
    path: 'power-unit/details',
    component: PowerUnitDetailsComponent
  }, {
    path: 'smart-home/details',
    component: SmartHomeDetailsOverviewComponent
  }, {
    path: 'smart-meter/details',
    component: SmartMeterDetailsComponent
  }, {
    path: 'smart-home/overview',
    component: SmartHomeOverviewComponent
  }, {
    path: '**',
    redirectTo: 'smart-home/overview'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
