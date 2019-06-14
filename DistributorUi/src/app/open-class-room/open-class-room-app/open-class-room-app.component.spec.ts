import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenClassRoomAppComponent } from './open-class-room-app.component';

describe('OpenClassRoomAppComponent', () => {
  let component: OpenClassRoomAppComponent;
  let fixture: ComponentFixture<OpenClassRoomAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenClassRoomAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenClassRoomAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
