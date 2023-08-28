import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateClientAdminComponent } from './update-client-admin.component';

describe('UpdateClientAdminComponent', () => {
  let component: UpdateClientAdminComponent;
  let fixture: ComponentFixture<UpdateClientAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateClientAdminComponent]
    });
    fixture = TestBed.createComponent(UpdateClientAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
