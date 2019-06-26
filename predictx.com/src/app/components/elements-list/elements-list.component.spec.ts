import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { AppModule } from '../../app.module'

import { ElementsListComponent } from './elements-list.component'

import Dashboards from '../../model/dashboards'
import Dashboard from '../../model/dashboard'

describe('ElementsListComponent', () => {

  let component: ElementsListComponent
  let fixture: ComponentFixture<ElementsListComponent>

  const firstDashboard = new Dashboard(-1, 'name', [])

  beforeEach(async(() => TestBed.configureTestingModule({ imports: [ AppModule ] }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(ElementsListComponent)
    component = fixture.componentInstance
    component.dashboards = new Dashboards([firstDashboard])
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })
})
