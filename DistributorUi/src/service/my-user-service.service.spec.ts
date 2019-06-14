import { TestBed } from '@angular/core/testing';

import { MyUserServiceService } from './my-user-service.service';

describe('MyUserServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MyUserServiceService = TestBed.get(MyUserServiceService);
    expect(service).toBeTruthy();
  });
});
