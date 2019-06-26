import { Component } from '@angular/core'

import Dashboards from '../../model/dashboards'
import sampleJSON from '../../services/data/json5'

@Component({
  selector: 'app-element-add',
  templateUrl: './element-add.component.html',
  styleUrls: ['./element-add.component.css']
})

export class ElementAddComponent {

  public dashboards: Dashboards

  sampleJSON: string = JSON.stringify(sampleJSON)

  createElement(name: string, json: string, colspan: number, rowspan: number) {
    this.dashboards.selected.addElement(name, JSON.parse(json), colspan, rowspan)
  }
}
