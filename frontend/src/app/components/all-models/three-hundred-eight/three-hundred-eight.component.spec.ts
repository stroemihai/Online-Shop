import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThreeHundredEightComponent } from './three-hundred-eight.component';

describe('ThreeHundredEightComponent', () => {
  let component: ThreeHundredEightComponent;
  let fixture: ComponentFixture<ThreeHundredEightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ThreeHundredEightComponent]
    });
    fixture = TestBed.createComponent(ThreeHundredEightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
