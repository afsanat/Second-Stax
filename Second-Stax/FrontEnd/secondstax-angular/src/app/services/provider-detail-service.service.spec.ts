import { TestBed } from '@angular/core/testing';

import { ProviderDetailServiceService } from './provider-detail-service.service';

describe('ProviderDetailServiceService', () => {
  let service: ProviderDetailServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProviderDetailServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
