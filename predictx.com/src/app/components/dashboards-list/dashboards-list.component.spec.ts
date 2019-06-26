import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { AppModule } from '../../app.module'

import { DashboardsListComponent } from './dashboards-list.component'

import Dashboards from '../../model/dashboards'
import Dashboard from '../../model/dashboard'

describe('DashboardsListComponent', () => {

  let component: DashboardsListComponent
  let fixture: ComponentFixture<DashboardsListComponent>

  const firstDashboard = new Dashboard(-1, 'name', [])

  beforeEach(async(() => TestBed.configureTestingModule({ imports: [ AppModule ] }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardsListComponent)
    component = fixture.componentInstance
    component.dashboards = new Dashboards([firstDashboard])
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })
})
