import { Component, Input } from '@angular/core'
import { MdDialog } from '@angular/material'

import { ElementAddComponent } from 'app/components/element-add/element-add.component'
import Dashboards from '../../model/dashboards'

@Component({
  selector: 'app-elements-list',
  templateUrl: './elements-list.component.html',
  styleUrls: ['./elements-list.component.css'],
})

export class ElementsListComponent {

  @Input() dashboards: Dashboards

  constructor(public dialog: MdDialog) {}

  openDialog() {
    this.dialog.open(ElementAddComponent).componentInstance.dashboards = this.dashboards
  }
}
