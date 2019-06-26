import { Component, Input } from '@angular/core'

import Dashboards from '../../model/dashboards'

@Component({
  selector: 'app-dashboard-show',
  templateUrl: './dashboard-show.component.html',
  styleUrls: ['./dashboard-show.component.css'],
})

export class DashboardShowComponent {

  @Input() dashboards: Dashboards
}
