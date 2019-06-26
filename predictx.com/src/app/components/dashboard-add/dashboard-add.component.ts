import { Component } from '@angular/core'
import Dashboards from '../../model/dashboards'

@Component({
  selector: 'app-dashboard-add',
  templateUrl: './dashboard-add.component.html',
  styleUrls: ['./dashboard-add.component.css']
})

export class DashboardAddComponent {

  public dashboards: Dashboards

  createDashboard(name: string, columns: number) {
    this.dashboards.add(name, columns)
  }
}
