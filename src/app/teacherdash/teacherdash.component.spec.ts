import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherdashComponent } from './teacherdash.component';

describe('TeacherdashComponent', () => {
  let component: TeacherdashComponent;
  let fixture: ComponentFixture<TeacherdashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TeacherdashComponent]
    });
    fixture = TestBed.createComponent(TeacherdashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});