import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {ITEMS_URL} from '../APIStrings';

@Injectable()
export class ApiFetchService {

  constructor(private httpClient: HttpClient) { }

  fetchItems(): Observable<Object> {
    return this.httpClient.get(ITEMS_URL);
  }

}
export interface MyData {
  accessGroupName: string;
  accessGroupId: number;
  totalUses: number;
  sessions: any;
  eventId: number;
  structureDecode: boolean;
  name: string;
  modified: string;
  id: number;
  basicProductId: number;
}
