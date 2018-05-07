import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindWordsComponent } from './find-words.component';

describe('FindWordsComponent', () => {
  let component: FindWordsComponent;
  let fixture: ComponentFixture<FindWordsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindWordsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindWordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
