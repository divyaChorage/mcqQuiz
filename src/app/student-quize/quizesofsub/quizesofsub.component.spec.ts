import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizesofsubComponent } from './quizesofsub.component';

describe('QuizesofsubComponent', () => {
  let component: QuizesofsubComponent;
  let fixture: ComponentFixture<QuizesofsubComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [QuizesofsubComponent]
    });
    fixture = TestBed.createComponent(QuizesofsubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
