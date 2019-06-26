import {Component, Input} from '@angular/core'

import Dashboards from '../../model/dashboards'
import {MdDialog} from '@angular/material'
import {DashboardAddComponent} from '../dashboard-add/dashboard-add.component'

@Component({
  selector: 'app-dashboards-list',
  templateUrl: './dashboards-list.component.html',
  styleUrls: ['./dashboards-list.component.css'],
})

export class DashboardsListComponent {

  @Input() dashboards: Dashboards

  constructor(public dialog: MdDialog) {}

  openDialog() {
    this.dialog.open(DashboardAddComponent).componentInstance.dashboards = this.dashboards
  }
}
