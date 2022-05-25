import {Injectable} from '@angular/core';
import {RestHelperService} from './rest-helper.service';
import {NamedModel} from '../models/NamedModel';
import {SmartHomeModel} from '../models/SmartHomeModel';

@Injectable({
  providedIn: 'root'
})
export class SmartHomeService extends RestHelperService<SmartHomeModel, NamedModel> {
  path = 'smart-home';
}
