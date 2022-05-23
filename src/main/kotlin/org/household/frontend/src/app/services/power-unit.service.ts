import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import { Observable } from 'rxjs';
import {PowerUnitModel} from '../models/PowerUnitModel';

@Injectable({
  providedIn: 'root'
})
export class PowerUnitService extends RestHelperService<PowerUnitModel, NamedModel> {
  path = 'power-unit';

  public findAllBySmartHomeId(smartHomeId: string): Observable<NamedModel[]> {
    const url = `${this.getBaseUrl(this.path)}/findAllBySmartHomeId?smartHomeId=${smartHomeId}`;
    return this.http.get<NamedModel[]>(url, this.getHeadersWithoutCredentials());
  }
}
