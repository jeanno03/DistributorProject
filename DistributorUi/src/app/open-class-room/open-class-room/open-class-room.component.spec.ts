import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenClassRoomComponent } from './open-class-room.component';

describe('OpenClassRoomComponent', () => {
  let component: OpenClassRoomComponent;
  let fixture: ComponentFixture<OpenClassRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenClassRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenClassRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
