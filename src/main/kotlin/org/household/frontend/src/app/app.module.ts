import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {FlexLayoutModule} from '@angular/flex-layout';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import {HttpClient} from '@angular/common/http';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTabsModule} from '@angular/material/tabs';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { ElectricalDeviceOverviewComponent } from './toolbar/electrical-device-overview/electrical-device-overview.component';
import { PowerChargerOverviewComponent } from './toolbar/power-charger-overview/power-charger-overview.component';
import { PowerStorageOverviewComponent } from './toolbar/power-storage-overview/power-storage-overview.component';
import { PowerUnitOverviewComponent } from './toolbar/power-unit-overview/power-unit-overview.component';
import { SmartMeterOverviewComponent } from './toolbar/smart-meter-overview/smart-meter-overview.component';
import { SmartHomeDetailsComponent } from './toolbar/smart-home-details/smart-home-details.component';
import { ElectricalDeviceDetailsComponent } from './details/electrical-device-details/electrical-device-details.component';
import { PowerChargerDetailsComponent } from './details/power-charger-details/power-charger-details.component';
import { PowerStorageDetailsComponent } from './details/power-storage-details/power-storage-details.component';
import { PowerUnitDetailsComponent } from './details/power-unit-details/power-unit-details.component';
import { SmartMeterDetailsComponent } from './details/smart-meter-details/smart-meter-details.component';
import { GenericListComponent } from './generics/generic-list/generic-list.component';
import { GenericListWrapperComponent } from './generics/generic-list-wrapper/generic-list-wrapper.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";

export function HttpLoaderFactory(http: HttpClient): TranslateHttpLoader {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    ElectricalDeviceOverviewComponent,
    PowerChargerOverviewComponent,
    PowerStorageOverviewComponent,
    PowerUnitOverviewComponent,
    SmartMeterOverviewComponent,
    SmartHomeDetailsComponent,
    ElectricalDeviceDetailsComponent,
    PowerChargerDetailsComponent,
    PowerStorageDetailsComponent,
    PowerUnitDetailsComponent,
    SmartMeterDetailsComponent,
    GenericListComponent,
    GenericListWrapperComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    FormsModule,
    MatInputModule,
    MatDialogModule,
    MatSnackBarModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatTabsModule,
    ReactiveFormsModule,
    TranslateModule.forRoot({
      defaultLanguage: 'de',
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
  ],
  exports: [
    ToolbarComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
