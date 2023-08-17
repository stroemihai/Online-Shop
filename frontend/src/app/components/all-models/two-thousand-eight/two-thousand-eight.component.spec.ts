import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoThousandEightComponent } from './two-thousand-eight.component';

describe('TwoThousandEightComponent', () => {
  let component: TwoThousandEightComponent;
  let fixture: ComponentFixture<TwoThousandEightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TwoThousandEightComponent]
    });
    fixture = TestBed.createComponent(TwoThousandEightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
