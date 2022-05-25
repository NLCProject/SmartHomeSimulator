import {Component, Input, NgZone, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PromptComponent} from '../../shared/prompt/prompt.component';
import {ActivatedRoute, Router} from '@angular/router';
import {TranslationService} from '../../services/translation.service';
import {MatDialog} from '@angular/material/dialog';
import {RouterUtilService} from '../../services/router-util.service';
import { I18nKey } from 'src/app/models/I18nKey';
import {SmartMeterService} from '../../services/smart-meter.service';
import {SmartMeterModel} from '../../models/SmartMeterModel';
import {FlowDirection} from '../../models/FlowDirection';

@Component({
  selector: 'app-smart-meter-details',
  templateUrl: './smart-meter-details.component.html',
  styleUrls: ['./smart-meter-details.component.scss']
})
export class SmartMeterDetailsComponent extends RouterUtilService implements OnInit {

  constructor(
      router: Router,
      ngZone: NgZone,
      private service: SmartMeterService,
      private translationService: TranslationService,
      private activatedRoute: ActivatedRoute,
      private formBuilder: FormBuilder,
      private dialog: MatDialog
  ) {
    super(router, ngZone, 'smart-meter', 5);
  }

  @Input()
  public smartHomeId: string;

  public I18nKey = I18nKey;
  public id: string;
  public model: SmartMeterModel;
  public formGroup: FormGroup;
  public loading = false;
  public isVisible = false;

  ngOnInit(): void {
    this.createForm();
    this.loadData();
  }

  public getParentRouterPath(): string {
    return `smart-home/details/${this.smartHomeId}`;
  }

  public getTypes(): string[] {
    return Object.keys(FlowDirection).filter(key => typeof FlowDirection[key as any] === 'number');
  }

  public updateModel(): void {
    this.loading = true;
    const newModel = !this.model;
    if (newModel) {
      this.model = new SmartMeterModel();
    }

    const controls = this.formGroup.controls;
    this.model.smartHomeId = this.smartHomeId;
    this.model.name = controls.name.value;
    this.model.powerExported = +controls.powerExported.value;
    this.model.powerImported = +controls.powerImported.value;
    this.model.currentFlowRate = +controls.currentFlowRate.value;
    this.model.maxFlowRate = +controls.maxFlowRate.value;
    this.model.flowDirection = controls.flowDirection.value;

    this.service.save(this.model).subscribe(
        response => {
          this.translationService.showSnackbar('Updated');
          this.loading = false;
          this.reloadDetailView(response.id, this.smartHomeId);
        },
        error => {
          this.translationService.showSnackbarOnError(error);
          this.loading = false;
        }
    );
  }

  public delete(): void {
    const promptDialog = this.dialog.open(PromptComponent, {
      panelClass: 'mat-dialog-container-small',
      data: { translationKey: 'Want To Delete', showAccept: true }
    });

    promptDialog.afterClosed().subscribe(result => {
      if (result) {
        this.loading = true;
        this.service.delete(this.model.id).subscribe(
            () => {
              this.translationService.showSnackbar('Deleted');
              this.returnToDetails();
            },
            error => {
              this.translationService.showSnackbarOnError(error);
              this.loading = false;
            }
        );
      }
    });
  }

  private loadData(): void {
    this.loading = true;
    this.service.findById(this.id).subscribe(
        response => {
          this.model = response;
          this.setValues(response);
        },
        error => {
          this.translationService.showSnackbarOnError(error);
          this.loading = false;
        }
    );
  }

  private setValues(model: SmartMeterModel): void {
    this.formGroup.setValue({
      name: model.name,
      powerExported: model.powerExported,
      powerImported: model.powerImported,
      currentFlowRate: model.currentFlowRate,
      maxFlowRate: model.maxFlowRate,
      flowDirection: model.flowDirection
    });

    this.loading = false;
  }

  private createForm(): void {
    this.formGroup = this.formBuilder.group(
        {
          name: [null, Validators.compose([Validators.required])],
          powerExported: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          powerImported: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          currentFlowRate: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          maxFlowRate: [null, Validators.compose([Validators.required, Validators.min(1), Validators.pattern('^[0-9.]*$')])],
          flowDirection: [null, Validators.compose([Validators.required])]
        }
    );

    this.formGroup.valueChanges.subscribe(() => {
      this.isVisible = true;
    });

    this.loading = false;
  }
}
