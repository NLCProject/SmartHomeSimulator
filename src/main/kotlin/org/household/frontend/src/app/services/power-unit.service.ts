import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {PowerUnitModel} from '../models/PowerUnitModel';

@Injectable({
  providedIn: 'root'
})
export class PowerUnitService extends RestHelperService<PowerUnitModel, NamedModel> {
  path = 'power-unit';
}
