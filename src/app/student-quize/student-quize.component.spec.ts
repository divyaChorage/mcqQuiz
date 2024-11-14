import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentQuizeComponent } from './student-quize.component';

describe('StudentQuizeComponent', () => {
  let component: StudentQuizeComponent;
  let fixture: ComponentFixture<StudentQuizeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StudentQuizeComponent]
    });
    fixture = TestBed.createComponent(StudentQuizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
