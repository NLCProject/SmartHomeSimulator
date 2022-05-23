import {Component, NgZone, OnInit} from '@angular/core';
import {RouterUtilService} from '../../services/router-util.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '@angular/common';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SmartHomeModel} from '../../models/SmartHomeModel';
import {SmartHomeService} from '../../services/smart-home.service';
import { TranslationService } from 'src/app/services/translation.service';
import { MatDialog } from '@angular/material/dialog';
import {PromptComponent} from '../../shared/prompt/prompt.component';

@Component({
  selector: 'app-smart-home-details',
  templateUrl: './smart-home-details.component.html',
  styleUrls: ['./smart-home-details.component.scss']
})
export class SmartHomeDetailsComponent extends RouterUtilService implements OnInit {

  constructor(
    router: Router,
    ngZone: NgZone,
    location: Location,
    private service: SmartHomeService,
    private translationService: TranslationService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private dialog: MatDialog
  ) {
    super(router, ngZone, location, 'smart-home', 0);
  }

  public formGroup: FormGroup;
  public loading = false;
  public id: string;
  public isVisible = false;
  public model: SmartHomeModel;

  ngOnInit(): void {
    this.createForm();
    this.getId();
  }

  public updateModel(): void {
    this.loading = true;
    const newModel = !this.model;
    if (newModel) {
      this.model = new SmartHomeModel();
    }
    const controls = this.formGroup.controls;
    this.model.name = controls.name.value;

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
            this.return();
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

  private setValues(model: SmartHomeModel): void {
    this.formGroup.setValue({
      name: model.name
    });

    this.loading = false;
  }

  private createForm(): void {
    this.formGroup = this.formBuilder.group(
      {
        name: [null, Validators.compose([Validators.required])]
      }
    );

    this.formGroup.valueChanges.subscribe(() => {
      this.isVisible = true;
    });

    this.loading = false;
  }
}
