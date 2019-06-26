import { Injectable } from '@angular/core'

import Dashboards from '../model/dashboards'

import dashboards from './data/index'

@Injectable()
export class DashboardsService {

  dashboards: Dashboards = dashboards
}
