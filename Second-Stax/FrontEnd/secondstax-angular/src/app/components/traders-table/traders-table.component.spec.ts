import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradersTableComponent } from './traders-table.component';

describe('TradersTableComponent', () => {
  let component: TradersTableComponent;
  let fixture: ComponentFixture<TradersTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TradersTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TradersTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
