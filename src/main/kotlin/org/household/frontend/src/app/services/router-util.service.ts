import {Injectable, NgZone} from '@angular/core';
import {Router} from '@angular/router';
import {Location} from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export abstract class RouterUtilService {

  protected constructor(
    protected router: Router,
    private ngZone: NgZone,
    private location: Location,
    public routerPath: string,
    protected index: number,
) { }

  public getRoute(): string {
    return this.routerPath;
  }

  public getIndex(): number {
    return this.index;
  }

  public returnToDetails(): void {
    this.ngZone.run(() => this.router.navigate([`/smart-home/details`, { index: this.index }]));
  }

  public returnToOverview(): void {
    this.ngZone.run(() => this.router.navigate([`/smart-home/overview`]));
  }

  public routeToPath(path: string, parameter: string): void {
    this.router.navigate([`/${path}`, parameter]);
  }

  public reloadDetailView(id: string): void {
    // Force reload of page
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.router.navigate([`/${this.routerPath}/details`, id]);
    });
  }
}
