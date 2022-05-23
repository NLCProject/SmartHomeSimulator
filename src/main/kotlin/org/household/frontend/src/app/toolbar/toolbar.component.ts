import { Component } from '@angular/core';
import {SmartHomeService} from '../services/smart-home.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  constructor(
    public service: SmartHomeService
  ) { }
}
