import {Component, EventEmitter, HostListener, Input, Output} from '@angular/core';
import {I18nKey} from '../../models/I18nKey';
import {NamedModel} from '../../models/NamedModel';
import {Router, UrlTree} from '@angular/router';

@Component({
  selector: 'app-generic-list',
  templateUrl: './generic-list.component.html',
  styleUrls: ['./generic-list.component.scss']
})
export class GenericListComponent {

  constructor(
    private router: Router
  ) { }

  @Input()
  public models: NamedModel[] = [];

  @Input()
  public loading = true;

  @Input()
  public routerPath: string = null;

  @Output()
  private newPage: EventEmitter<number> = new EventEmitter();

  @Input()
  public smartHomeId: string = null;

  public I18nKey = I18nKey;
  public isVisible = false;
  private page = 0;
  private readonly showScrollToTopPercentage = 50;

  public static getScrollPercent(element): number {
    return (element.scrollTop / (element.scrollHeight - element.clientHeight)) * 100;
  }

  public handleMiddleClick(event, model: NamedModel): void {
    event.preventDefault();
    if (event.which === 2) {
      this.openInNewView(model);
    }
  }

  public openInNewView(model: NamedModel): void {
    let urlTree: UrlTree;
    if (this.smartHomeId?.length > 0) {
      urlTree = this.router.createUrlTree([`/${this.routerPath}/details`, model.id, this.smartHomeId]);
    } else {
      urlTree = this.router.createUrlTree([`/${this.routerPath}/details`, model.id]);
    }

    const url = this.router.serializeUrl(urlTree);
    window.open(url, '_blank');
  }

  public toTop(): void {
    document.querySelector('#content').scrollTop = 0;
  }

  public openDetails(model: NamedModel): void {
    if (!this.routerPath || !model) {
      return;
    }

    if (this.smartHomeId?.length > 0) {
      this.router.navigate([`/${this.routerPath}/details`, model.id, this.smartHomeId]);
    } else {
      this.router.navigate([`/${this.routerPath}/details`, model.id]);
    }
  }

  @HostListener('scroll', ['$event'])
  public onScrollHost($event: Event): void {
    const scrollPercentage = GenericListComponent.getScrollPercent($event.target);
    this.isVisible = scrollPercentage > this.showScrollToTopPercentage;
  }

  public onScroll(): void {
    this.page++;
    this.newPage.emit(this.page);
  }
}
