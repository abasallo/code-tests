import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { AppModule } from '../../app.module'

import { DashboardShowComponent } from './dashboard-show.component'

import Dashboards from '../../model/dashboards'
import Dashboard from '../../model/dashboard'

describe('DashboardShowComponent', () => {

  let component: DashboardShowComponent
  let fixture: ComponentFixture<DashboardShowComponent>

  const firstDashboard = new Dashboard(-1, 'name', [])

  beforeEach(async(() => TestBed.configureTestingModule({ imports: [ AppModule ] }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardShowComponent)
    component = fixture.componentInstance
    component.dashboards = new Dashboards([firstDashboard])
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })
})
