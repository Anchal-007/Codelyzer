import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQuizByCategoryComponent } from './view-quiz-by-category.component';

describe('ViewQuizByCategoryComponent', () => {
  let component: ViewQuizByCategoryComponent;
  let fixture: ComponentFixture<ViewQuizByCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewQuizByCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewQuizByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
