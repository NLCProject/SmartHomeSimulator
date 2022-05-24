import {Component, Input, OnInit} from '@angular/core';
import {RestHelperService} from '../../services/rest-helper.service';
import {NamedModel} from '../../models/NamedModel';
import {TranslationService} from '../../services/translation.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-generic-list-wrapper',
  templateUrl: './generic-list-wrapper.component.html',
  styleUrls: ['./generic-list-wrapper.component.scss']
})
export class GenericListWrapperComponent implements OnInit {

  constructor(
    private translationService: TranslationService,
    private router: Router
  ) { }

  @Input()
  public service: RestHelperService<any, any>;

  @Input()
  private loading = false;

  @Input()
  public routerPath: string;

  @Input()
  public smartHomeId: string = null;

  private page = 0;
  private loadingDomain = true;
  public models: NamedModel[] = [];

  private static distinct(array: NamedModel[]): NamedModel[] {
    return array
      .filter((value: NamedModel, index: number, self: NamedModel[]) => {
        return self.map(x => x.id).indexOf(value.id) === index;
      });
  }

  ngOnInit(): void {
    this.loadData();
  }

  public getSmartHomeId(): string {
    return this.smartHomeId;
  }

  public isLoading(): boolean {
    return this.loading || this.loadingDomain;
  }

  public newPage(page: number): void {
    this.page = page;
    this.loadData();
  }

  public routeToAddDialog(): void {
    if (this.smartHomeId?.length > 0) {
      this.router.navigate([`/${this.routerPath}/details`, '', this.smartHomeId]);
    } else {
      this.router.navigate([`/${this.routerPath}/details`]);
    }
  }

  private loadData(): void {
    if (this.smartHomeId?.length > 0) {
      this.findAllBySmartHomeId();
    } else {
      this.findAllPageable();
    }
  }

  private findAllBySmartHomeId(): void {
    this.loadingDomain = true;
    this.service.findAllBySmartHomeId(this.page, this.smartHomeId).subscribe(
        response => {
          this.models = this.models.concat(response);
          this.models = GenericListWrapperComponent.distinct(this.models);

          this.loadingDomain = false;
        },
        error => {
          this.translationService.showSnackbarOnError(error);
          this.loadingDomain = false;
        }
    );
  }

  private findAllPageable(): void {
    this.loadingDomain = true;
    this.service.findAllPageable(this.page).subscribe(
      response => {
        this.models = this.models.concat(response);
        this.models = GenericListWrapperComponent.distinct(this.models);

        this.loadingDomain = false;
      },
      error => {
        this.translationService.showSnackbarOnError(error);
        this.loadingDomain = false;
      }
    );
  }
}
