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

  public return(suffix: string): void {
    if (this.routerPath && this.index) {
      this.ngZone.run(() => this.router.navigate([`/${this.routerPath}/${suffix}`, { index: this.index }]));
    }

    this.location.back();
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
