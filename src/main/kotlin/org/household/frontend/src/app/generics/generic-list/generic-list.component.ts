import {Component, EventEmitter, HostListener, Input, Output} from '@angular/core';
import {I18nKey} from "../../models/I18nKey";
import {NamedModel} from "../../models/NamedModel";
import {Router} from "@angular/router";

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
    const url = this.router.serializeUrl(
      this.router.createUrlTree([`/${this.routerPath}/details`, model.id])
    );

    window.open(url, '_blank');
  }

  public toTop(): void {
    document.querySelector('#content').scrollTop = 0;
  }

  public openDetails(model: NamedModel): void {
    if (!this.routerPath || !model) {
      return;
    }

    this.router.navigate([`/${this.routerPath}/details`, model.id]);
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
