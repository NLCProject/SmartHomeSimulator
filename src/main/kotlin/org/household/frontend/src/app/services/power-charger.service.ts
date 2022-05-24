import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {PowerChargerModel} from '../models/PowerChargerModel';

@Injectable({
  providedIn: 'root'
})
export class PowerChargerService extends RestHelperService<PowerChargerModel, NamedModel> {
  path = 'power-charger';
}
