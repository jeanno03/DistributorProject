import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppareilViewSimpleComponent } from './appareil-view-simple.component';

describe('AppareilViewSimpleComponent', () => {
  let component: AppareilViewSimpleComponent;
  let fixture: ComponentFixture<AppareilViewSimpleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppareilViewSimpleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppareilViewSimpleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
