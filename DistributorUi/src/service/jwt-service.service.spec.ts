import { TestBed } from '@angular/core/testing';

import { JwtServiceService } from './jwt-service.service';

describe('JwtServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JwtServiceService = TestBed.get(JwtServiceService);
    expect(service).toBeTruthy();
  });
});
