import { ComponentFixture, TestBed } from '@angular/core/testing';

import { McaddComponent } from './mcadd.component';

describe('McaddComponent', () => {
  let component: McaddComponent;
  let fixture: ComponentFixture<McaddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [McaddComponent]
    });
    fixture = TestBed.createComponent(McaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
