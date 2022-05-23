import {Component, NgZone, OnInit} from '@angular/core';
import { I18nKey } from 'src/app/models/I18nKey';
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
    private dialog: MatDialog,
    private route: ActivatedRoute
  ) {
    super(router, ngZone, location, 'smart-home', 0);
  }

  public I18nKey = I18nKey;
  public formGroup: FormGroup;
  public loading = false;
  public id: string;
  public isVisible = false;
  public model: SmartHomeModel;
  public selectedTab = 0;
  private swipeCoordinate: [number, number];
  private swipeTime = 0;
  private numberTabs = 6;

  ngOnInit(): void {
    this.createForm();
    this.getId();
    this.selectedTab = +JSON.parse(this.route.snapshot.paramMap.get('index'));
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
        this.reloadDetailView(response.id);
        this.loading = false;
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

  public swipe(event: TouchEvent, when: string): void {
    const coordinate: [number, number] = [event.changedTouches[0].clientX, event.changedTouches[0].clientY];
    const time = new Date().getTime();

    if (when === 'start') {
      this.swipeCoordinate = coordinate;
      this.swipeTime = time;
    } else if (when === 'end') {
      const direction = [coordinate[0] - this.swipeCoordinate[0], coordinate[1] - this.swipeCoordinate[1]];
      const duration = time - this.swipeTime;

      if (
        duration < 1000 // Long enough
        && Math.abs(direction[0]) > 30 // Long enough
        && Math.abs(direction[0]) > Math.abs(direction[1] * 3) // Horizontal enough
      ) {
        const swipe = direction[0] < 0 ? 'next' : 'previous';
        if (swipe === 'next') {
          if (this.selectedTab < this.numberTabs - 1) {
            this.selectedTab += 1;
          } else {
            this.selectedTab = 0;
          }
        } else if (swipe === 'previous') {
          if (this.selectedTab === 0) {
            this.selectedTab = this.numberTabs - 1;
          } else {
            this.selectedTab -= 1;
          }
        }
      }
    }
  }
}
