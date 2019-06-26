import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import {MdDialogRef} from '@angular/material'

import { AppModule } from '../../app.module'
import { DashboardAddComponent } from './dashboard-add.component'
import Dashboards from '../../model/dashboards'


describe('DashboardAddComponent', () => {

  let component: DashboardAddComponent
  let fixture: ComponentFixture<DashboardAddComponent>

  beforeEach(async(() => TestBed.configureTestingModule({
    imports: [ AppModule ],
    providers: [{ provide: MdDialogRef }]
  }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardAddComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })

  it('creates a new Dashboard', () => {

    const dashboard = new DashboardAddComponent()
    dashboard.dashboards = new Dashboards([])

    dashboard.createDashboard('test', 2)

    const firstDashboard = dashboard.dashboards.list[0]
    expect(firstDashboard.name).toBe('test')
    expect(firstDashboard.columns).toBe(2)
  })
})
