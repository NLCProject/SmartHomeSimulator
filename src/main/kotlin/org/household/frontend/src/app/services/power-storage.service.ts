import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import { Observable } from 'rxjs';
import {PowerStorageModel} from '../models/PowerStorageModel';

@Injectable({
  providedIn: 'root'
})
export class PowerStorageService extends RestHelperService<PowerStorageModel, NamedModel> {
  path = 'power-storage';

  public findAllBySmartHomeId(smartHomeId: string): Observable<NamedModel[]> {
    const url = `${this.getBaseUrl(this.path)}/findAllBySmartHomeId?smartHomeId=${smartHomeId}`;
    return this.http.get<NamedModel[]>(url, this.getHeaders());
  }
}
