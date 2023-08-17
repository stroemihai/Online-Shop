import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoHundredEightComponent } from './two-hundred-eight.component';

describe('TwoHundredEightComponent', () => {
  let component: TwoHundredEightComponent;
  let fixture: ComponentFixture<TwoHundredEightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TwoHundredEightComponent]
    });
    fixture = TestBed.createComponent(TwoHundredEightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
