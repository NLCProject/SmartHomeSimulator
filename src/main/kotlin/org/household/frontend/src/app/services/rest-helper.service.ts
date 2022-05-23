import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {IdModel} from '../models/IdModel';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export abstract class RestHelperService<MODEL, ABSTRACTMODEL> {

  protected abstract path: string;

  protected constructor(
    protected http: HttpClient
  ) { }

  protected getBaseUrl(path: string): string {
    return `${environment.SERVER_URL}:8080/` + path;
  }

  protected getHeadersWithoutCredentials(): { headers: HttpHeaders } {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  }

  public save(model: MODEL): Observable<IdModel> {
    const url = `${this.getBaseUrl(this.path)}/save`;
    return this.http.post<IdModel>(url, model, this.getHeadersWithoutCredentials());
  }

  public delete(id: string): Observable<void> {
    const url = `${this.getBaseUrl(this.path)}/delete?id=${id}`;
    return this.http.post<void>(url, null, this.getHeadersWithoutCredentials());
  }

  public findById(id: string): Observable<MODEL> {
    const url = `${this.getBaseUrl(this.path)}/findById?id=${id}`;
    return this.http.get<MODEL>(url, this.getHeadersWithoutCredentials());
  }

  public findAll(): Observable<ABSTRACTMODEL[]> {
    const url = `${this.getBaseUrl(this.path)}/findAll`;
    return this.http.get<ABSTRACTMODEL[]>(url, this.getHeadersWithoutCredentials());
  }

  public findAllPageable(page: number): Observable<ABSTRACTMODEL[]> {
    const url = `${this.getBaseUrl(this.path)}/findAllPageable?page=${page}`;
    return this.http.get<ABSTRACTMODEL[]>(url, this.getHeadersWithoutCredentials());
  }
}
