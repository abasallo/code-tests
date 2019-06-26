import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import {MdDialogRef} from '@angular/material'

import { AppModule } from './app.module'
import { AppComponent } from './app.component'
import { DashboardsService } from './services/dashboards.service'

describe('AppComponent', () => {

  let component: AppComponent
  let fixture: ComponentFixture<AppComponent>

  beforeEach(async(() => TestBed.configureTestingModule({
    imports: [ AppModule ],
    providers: [ { provide: MdDialogRef }, DashboardsService ]
  }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })
})
