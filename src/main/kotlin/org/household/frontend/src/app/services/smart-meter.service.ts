import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import { Observable } from 'rxjs';
import {SmartMeterModel} from '../models/SmartMeterModel';

@Injectable({
  providedIn: 'root'
})
export class SmartMeterService extends RestHelperService<SmartMeterModel, NamedModel> {
  path = 'smart-meter';

  public findBySmartHomeId(smartHomeId: string): Observable<SmartMeterModel> {
    const url = `${this.getBaseUrl(this.path)}/findBySmartHomeId?smartHomeId=${smartHomeId}`;
    return this.http.get<SmartMeterModel>(url, this.getHeaders());
  }
}
