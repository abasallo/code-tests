import { Component } from '@angular/core'

import { DashboardsService } from './services/dashboards.service'
import Dashboards from './model/dashboards'

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  providers: [ DashboardsService ]
})

export class AppComponent {

  dashboards: Dashboards = this.dashboardsService.dashboards

  constructor(public dashboardsService: DashboardsService) {}
}
