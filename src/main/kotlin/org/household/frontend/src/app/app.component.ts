import {Component, OnInit} from '@angular/core';
import {TranslationService} from './services/translation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(
    private translationService: TranslationService
  ) { }

  ngOnInit(): void {
    this.translationService.loadDefaultLanguage();
  }
}
