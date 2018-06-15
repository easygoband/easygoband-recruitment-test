import {Component, OnInit} from '@angular/core';
import {ApiFetchService, MyData} from '../services/api-fetch.service';
import {parserEpochDate} from '../util/utilities';
@Component({
  selector: 'app-items-viewer',
  templateUrl: './items-viewer.component.html',
  styleUrls: ['./items-viewer.component.css'],
  providers: [ApiFetchService]
})
export class ItemsViewerComponent implements OnInit {

  isLoading = true;
  dataList: Array<MyData> = [];
  numMatches = 0;
  constructor(private apiFetchService: ApiFetchService) {
  }

  retrieveData = (myData) => {
    this.dataList = [];
    Object.entries(myData).forEach(
      ([_, value]) => {
        const d: MyData = {
          name: value.name,
          accessGroupName: value.accessGroupName,
          accessGroupId: value.accessGroupId,
          totalUses: value.totalUses,
          sessions: value.sessions,
          eventId: value.eventId,
          structureDecode: value.structureDecode,
          modified: this.parserEpochToDate(value.modified),
          id: value.id,
          basicProductId: value.basicProductId
        };
        this.dataList.push(d);
      }
    );
  }


  ngOnInit() {
    this.apiFetchService.fetchItems().subscribe(
      data => this.retrieveData(data),
      error => {
        console.log(error);
        this.isLoading = false;
      },
      () => this.isLoading = false
    );
  }
  private parserEpochToDate(epoch: number): string {
    return parserEpochDate(epoch);
  }
  filterElems(filter: string) {
    this.numMatches = 0;
    let ul, li, i, card, title, content;
    ul = document.getElementById('myUL');
    li = ul.getElementsByTagName('mat-card-subtitle');
    title = ul.getElementsByTagName('mat-card-title');
    content = ul.getElementsByTagName('mat-card-content');
    card = ul.getElementsByTagName('mat-card');
    for (i = 0; i < li.length; i++) {
      if (li[i].innerHTML.toLocaleLowerCase().indexOf(filter) > -1 ||
        title[i].innerHTML.toLocaleLowerCase().indexOf(filter) > -1 ||
        content[i].innerHTML.toLocaleLowerCase().indexOf(filter) > -1) {

        card[i].style.display = '';
        this.numMatches++;
      } else {
        card[i].style.display = 'none';
      }
    }
  }

}
