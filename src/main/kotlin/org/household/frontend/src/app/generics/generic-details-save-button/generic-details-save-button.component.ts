import {Component, EventEmitter, Input, Output} from '@angular/core';
import {PromptComponent} from '../../shared/prompt/prompt.component';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';

@Component({
  selector: 'app-generic-details-save-button',
  templateUrl: './generic-details-save-button.component.html',
  styleUrls: ['./generic-details-save-button.component.scss']
})
export class GenericDetailsSaveButtonComponent {

  constructor(
    private router: Router,
    private dialog: MatDialog
  ) { }

  @Input()
  public isVisible = false;

  @Input()
  public loading = false;

  @Input()
  public disabled = false;

  @Input()
  public routerPath: string;

  @Output()
  public updateModel = new EventEmitter<void>();

  public loadNewView(): void {
    const promptDialog = this.dialog.open(PromptComponent, {
      panelClass: 'mat-dialog-container-small',
      data: { translationKey: 'Want To Create New Entity', showAccept: true }
    });

    promptDialog.afterClosed().subscribe(result => {
      if (result) {
        this.router.navigate([`/${this.routerPath}/details`]);
      }
    });
  }
}
