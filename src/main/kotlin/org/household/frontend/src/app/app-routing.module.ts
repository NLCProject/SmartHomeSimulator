import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ElectricalDeviceDetailsComponent} from './details/electrical-device-details/electrical-device-details.component';
import {PowerChargerDetailsComponent} from './details/power-charger-details/power-charger-details.component';
import {PowerStorageDetailsComponent} from './details/power-storage-details/power-storage-details.component';
import {PowerUnitDetailsComponent} from './details/power-unit-details/power-unit-details.component';
import {SmartHomeDetailsComponent} from './toolbar/smart-home-details/smart-home-details.component';
import {SmartMeterDetailsComponent} from './details/smart-meter-details/smart-meter-details.component';

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
    component: SmartHomeDetailsComponent
  }, {
    path: 'smart-meter/details/:id',
    component: SmartMeterDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
