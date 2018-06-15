import { TestBed, inject } from '@angular/core/testing';

import { ApiFetchService } from './api-fetch.service';

describe('ApiFetchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApiFetchService]
    });
  });

  it('should be created', inject([ApiFetchService], (service: ApiFetchService) => {
    expect(service).toBeTruthy();
  }));
});
