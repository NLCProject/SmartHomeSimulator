import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {ElectricalDeviceModel} from '../models/ElectricalDeviceModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ElectricalDeviceService extends RestHelperService<ElectricalDeviceModel, NamedModel> {
  path = 'electrical-device';

  public findAllBySmartHomeId(smartHomeId: string): Observable<NamedModel[]> {
    const url = `${this.getBaseUrl(this.path)}/findAllBySmartHomeId?smartHomeId=${smartHomeId}`;
    return this.http.get<NamedModel[]>(url, this.getHeadersWithoutCredentials());
  }
}
