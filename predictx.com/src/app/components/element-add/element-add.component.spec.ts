import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { AppModule } from '../../app.module'

import { ElementAddComponent } from './element-add.component'

import Dashboards from '../../model/dashboards'
import Dashboard from '../../model/dashboard'
import {MdDialogRef} from '@angular/material'

describe('ElementAddComponent', () => {

  let component: ElementAddComponent
  let fixture: ComponentFixture<ElementAddComponent>

  const firstDashboard = new Dashboard(-1, 'name', [])

  beforeEach(async(() => TestBed.configureTestingModule({
    imports: [ AppModule ],
    providers: [{ provide: MdDialogRef }]
  }).compileComponents()))

  beforeEach(() => {
    fixture = TestBed.createComponent(ElementAddComponent)
    component = fixture.componentInstance
    component.dashboards = new Dashboards([firstDashboard])
    fixture.detectChanges()
  })

  it('should be properly rendered', () => {
    expect(component).toBeTruthy()
  })
})
