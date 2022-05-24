import {Component, Input, NgZone, OnInit} from '@angular/core';
import {RouterUtilService} from "../../services/router-util.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {TranslationService} from "../../services/translation.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {PromptComponent} from "../../shared/prompt/prompt.component";
import { ElectricalDeviceModel } from 'src/app/models/ElectricalDeviceModel';
import {ElectricalDeviceService} from "../../services/electrical-device.service";
import {ElectricalDevice} from "../../models/ElectricalDevice";

@Component({
  selector: 'app-electrical-device-details',
  templateUrl: './electrical-device-details.component.html',
  styleUrls: ['./electrical-device-details.component.scss']
})
export class ElectricalDeviceDetailsComponent  extends RouterUtilService implements OnInit {

  constructor(
      router: Router,
      ngZone: NgZone,
      location: Location,
      private service: ElectricalDeviceService,
      private translationService: TranslationService,
      private activatedRoute: ActivatedRoute,
      private formBuilder: FormBuilder,
      private dialog: MatDialog
  ) {
    super(router, ngZone, location, 'electrical-device', 1);
  }

  @Input()
  public id: string;

  @Input()
  public model: ElectricalDeviceModel;

  public formGroup: FormGroup;
  public loading = false;
  public isVisible = false;

  ngOnInit(): void {
    this.createForm();
    this.getId();
  }

  public getTypes(): string[] {
    return Object.keys(ElectricalDevice).filter(key => typeof ElectricalDevice[key as any] === 'number');
  }

  public updateModel(): void {
    this.loading = true;
    const newModel = !this.model;
    if (newModel) {
      this.model = new ElectricalDeviceModel();
    }

    const controls = this.formGroup.controls;
    this.model.smartHomeId = this.id
    this.model.name = controls.name.value;
    this.model.currentPowerConsumption = +controls.currentPowerConsumption.value;
    this.model.maxPowerConsumption = +controls.maxPowerConsumption.value;
    this.model.enabled = controls.enabled.value === 'true';
    this.model.type = controls.type.value;

    this.service.save(this.model).subscribe(
        response => {
          this.translationService.showSnackbar('Updated');
          this.loading = false;
          this.reloadDetailView(response.id);
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

  private setValues(model: ElectricalDeviceModel): void {
    this.formGroup.setValue({
      name: model.name,
      currentPowerConsumption: model.currentPowerConsumption,
      maxPowerConsumption: model.maxPowerConsumption,
      enabled: model.enabled,
      type: model.type
    });

    this.loading = false;
  }

  private createForm(): void {
    this.formGroup = this.formBuilder.group(
        {
          name: [null, Validators.compose([Validators.required])],
          currentPowerConsumption: [null, Validators.compose([Validators.required, Validators.pattern('^[0-9.]*$')])],
          maxPowerConsumption: [null, Validators.compose([Validators.required, Validators.min(1), Validators.pattern('^[0-9.]*$')])],
          enabled: [null, Validators.compose([Validators.required])],
          type: [null, Validators.compose([Validators.required])]
        }
    );

    this.formGroup.valueChanges.subscribe(() => {
      this.isVisible = true;
    });

    this.loading = false;
  }
}
