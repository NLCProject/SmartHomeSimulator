import {Component, NgZone, OnInit} from '@angular/core';
import {RouterUtilService} from '../../services/router-util.service';
import {ActivatedRoute, Router} from '@angular/router';
import {TranslationService} from '../../services/translation.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import {ElectricalDeviceModel} from '../../models/ElectricalDeviceModel';
import {ElectricalDevice} from '../../models/ElectricalDevice';
import {PromptComponent} from '../../shared/prompt/prompt.component';
import { I18nKey } from 'src/app/models/I18nKey';
import {PowerStorageService} from '../../services/power-storage.service';
import {PowerStorageModel} from '../../models/PowerStorageModel';

@Component({
  selector: 'app-power-storage-details',
  templateUrl: './power-storage-details.component.html',
  styleUrls: ['./power-storage-details.component.scss']
})
export class PowerStorageDetailsComponent extends RouterUtilService implements OnInit {

  constructor(
      router: Router,
      ngZone: NgZone,
      private service: PowerStorageService,
      private translationService: TranslationService,
      private activatedRoute: ActivatedRoute,
      private formBuilder: FormBuilder,
      private dialog: MatDialog
  ) {
    super(router, ngZone, 'power-storage', 3);
  }

  public I18nKey = I18nKey;
  public id: string;
  public smartHomeId: string;
  public model: PowerStorageModel;
  public formGroup: FormGroup;
  public loading = false;
  public isVisible = false;

  ngOnInit(): void {
    this.createForm();
    this.getId();
  }

  public getParentRouterPath(): string {
    return `smart-home/details/${this.smartHomeId}`;
  }

  public updateModel(): void {
    this.loading = true;
    const newModel = !this.model;
    if (newModel) {
      this.model = new PowerStorageModel();
    }

    const controls = this.formGroup.controls;
    this.model.smartHomeId = this.smartHomeId;
    this.model.name = controls.name.value;
    this.model.currentChargingRate = +controls.currentChargingRate.value;
    this.model.maxChargingRate = +controls.maxChargingRate.value;
    this.model.maxPower = +controls.maxPower.value;
    this.model.currentPower = +controls.currentPower.value;
    this.model.enabled = controls.enabled.value === 'true';

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

  private getId(): void {
    this.activatedRoute.params.subscribe(params => {
      const smartHomeKey = 'smartHomeId';
      this.smartHomeId = params[smartHomeKey];

      const key = 'id';
      this.id = params[key];
      if (this.id?.length > 0) {
        this.loadData();
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

  private setValues(model: PowerStorageModel): void {
    this.formGroup.setValue({
      name: model.name,
      currentChargingRate: model.currentChargingRate,
      maxChargingRate: model.maxChargingRate,
      maxPower: model.maxPower,
      currentPower: model.currentPower,
      enabled: model.enabled
    });

    this.loading = false;
  }

  private createForm(): void {
    this.formGroup = this.formBuilder.group(
        {
          name: [null, Validators.compose([Validators.required])],
          currentChargingRate: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          maxChargingRate: [null, Validators.compose([Validators.required, Validators.min(1), Validators.pattern('^[0-9.]*$')])],
          maxPower: [null, Validators.compose([Validators.required, Validators.min(1), Validators.pattern('^[0-9.]*$')])],
          currentPower: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          enabled: [null]
        }
    );

    this.formGroup.valueChanges.subscribe(() => {
      this.isVisible = true;
    });

    this.loading = false;
  }
}
