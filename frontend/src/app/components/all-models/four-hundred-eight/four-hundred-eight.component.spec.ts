import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourHundredEightComponent } from './four-hundred-eight.component';

describe('FourHundredEightComponent', () => {
  let component: FourHundredEightComponent;
  let fixture: ComponentFixture<FourHundredEightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FourHundredEightComponent]
    });
    fixture = TestBed.createComponent(FourHundredEightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
