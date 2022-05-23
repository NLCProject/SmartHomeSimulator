import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import { Observable } from 'rxjs';
import {PowerChargerModel} from '../models/PowerChargerModel';

@Injectable({
  providedIn: 'root'
})
export class PowerChargerService extends RestHelperService<PowerChargerModel, NamedModel> {
  path = 'power-charger';

  public findAllBySmartHomeId(smartHomeId: string): Observable<NamedModel[]> {
    const url = `${this.getBaseUrl(this.path)}/findAllBySmartHomeId?smartHomeId=${smartHomeId}`;
    return this.http.get<NamedModel[]>(url, this.getHeadersWithoutCredentials());
  }
}
