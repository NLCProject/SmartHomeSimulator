import {Component, NgZone, OnInit} from '@angular/core';
import {RouterUtilService} from "../../services/router-util.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TranslationService} from "../../services/translation.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {PromptComponent} from "../../shared/prompt/prompt.component";
import { I18nKey } from 'src/app/models/I18nKey';
import {PowerUnitService} from "../../services/power-unit.service";
import {PowerUnitModel} from "../../models/PowerUnitModel";
import {PowerUnit} from "../../models/PowerUnit";

@Component({
  selector: 'app-power-unit-details',
  templateUrl: './power-unit-details.component.html',
  styleUrls: ['./power-unit-details.component.scss']
})
export class PowerUnitDetailsComponent extends RouterUtilService implements OnInit {

  constructor(
      router: Router,
      ngZone: NgZone,
      private service: PowerUnitService,
      private translationService: TranslationService,
      private activatedRoute: ActivatedRoute,
      private formBuilder: FormBuilder,
      private dialog: MatDialog
  ) {
    super(router, ngZone, 'power-unit', 4);
  }

  public I18nKey = I18nKey;
  public id: string;
  public smartHomeId: string;
  public model: PowerUnitModel;
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

  public getTypes(): string[] {
    return Object.keys(PowerUnit).filter(key => typeof PowerUnit[key as any] === 'number');
  }

  public updateModel(): void {
    this.loading = true;
    const newModel = !this.model;
    if (newModel) {
      this.model = new PowerUnitModel();
    }

    const controls = this.formGroup.controls;
    this.model.smartHomeId = this.smartHomeId;
    this.model.name = controls.name.value;
    this.model.maxPowerGeneration = +controls.maxPowerGeneration.value;
    this.model.currentPowerGeneration = +controls.currentPowerGeneration.value;
    this.model.enabled = controls.enabled.value === 'true';
    this.model.type = controls.type.value;

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

  private setValues(model: PowerUnitModel): void {
    this.formGroup.setValue({
      name: model.name,
      maxPowerGeneration: model.maxPowerGeneration,
      currentPowerGeneration: model.currentPowerGeneration,
      enabled: model.enabled,
      type: model.type
    });

    this.loading = false;
  }

  private createForm(): void {
    this.formGroup = this.formBuilder.group(
        {
          name: [null, Validators.compose([Validators.required])],
          maxPowerGeneration: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          currentPowerGeneration: [null, Validators.compose([Validators.required, Validators.min(1), Validators.pattern('^[0-9.]*$')])],
          enabled: [null],
          type: [null, Validators.compose([Validators.required])]
        }
    );

    this.formGroup.valueChanges.subscribe(() => {
      this.isVisible = true;
    });

    this.loading = false;
  }
}
