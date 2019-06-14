import { TestBed } from '@angular/core/testing';

import { DistributorServiceService } from './distributor-service.service';

describe('DistributorServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DistributorServiceService = TestBed.get(DistributorServiceService);
    expect(service).toBeTruthy();
  });
});
