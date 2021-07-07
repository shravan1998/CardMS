import { TestBed } from '@angular/core/testing';

import { CardMSServiceService } from './card-msservice.service';

describe('CardMSServiceService', () => {
  let service: CardMSServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardMSServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
