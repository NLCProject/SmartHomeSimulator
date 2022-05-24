import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {ElectricalDeviceModel} from '../models/ElectricalDeviceModel';

@Injectable({
  providedIn: 'root'
})
export class ElectricalDeviceService extends RestHelperService<ElectricalDeviceModel, NamedModel> {
  path = 'electrical-device';
}
