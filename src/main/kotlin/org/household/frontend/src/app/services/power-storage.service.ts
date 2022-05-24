import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {PowerStorageModel} from '../models/PowerStorageModel';

@Injectable({
  providedIn: 'root'
})
export class PowerStorageService extends RestHelperService<PowerStorageModel, NamedModel> {
  path = 'power-storage';
}
