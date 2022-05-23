import {Component, Input, NgZone} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-generic-details-return-button',
  templateUrl: './generic-details-return-button.component.html',
  styleUrls: ['./generic-details-return-button.component.scss']
})
export class GenericDetailsReturnButtonComponent {

  constructor(
    private router: Router,
    private ngZone: NgZone
  ) { }

  @Input()
  public titleI18nKey: string;

  @Input()
  private parentRouterPath: string;

  @Input()
  private tabIndex: number = null;

  public returnToRoute(): void {
    if (this.tabIndex) {
      this.ngZone.run(() => this.router.navigate([`/${this.parentRouterPath}`, { index: this.tabIndex }]));
    } else {
      this.ngZone.run(() => this.router.navigate([`/${this.parentRouterPath}`]));
    }
  }
}
