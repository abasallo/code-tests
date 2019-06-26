import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MdToolbarModule, MdSidenavModule, MdGridListModule, MdButtonModule, MdIconModule, MdDialogModule, MdInputModule } from '@angular/material'

import { ChartModule } from 'angular2-highcharts'
import { HighchartsStatic } from 'angular2-highcharts/dist/HighchartsService'

import { AppComponent } from './app.component'
import { DashboardsListComponent } from './components/dashboards-list/dashboards-list.component'
import { ElementsListComponent } from './components/elements-list/elements-list.component'
import { DashboardShowComponent } from './components/dashboard-show/dashboard-show.component'
import { DashboardAddComponent } from './components/dashboard-add/dashboard-add.component'
import { ElementAddComponent } from './components/element-add/element-add.component'

// This and some other unnecessary hacks in this file, are here due to https://github.com/gevgeny/angular2-highcharts/issues/163
declare const require: any // TODO - Review in the future

export function highchartsFactory() {
  const highCharts = require('highcharts')
  const drillDown = require('highcharts/modules/drilldown')
  drillDown(highCharts)
  return highCharts
}

@NgModule({
  imports: [ BrowserModule, BrowserAnimationsModule, ChartModule, MdToolbarModule, MdSidenavModule, MdGridListModule, MdButtonModule, MdIconModule, MdDialogModule, MdInputModule ],
  declarations: [ AppComponent, DashboardsListComponent, ElementsListComponent, DashboardShowComponent, DashboardAddComponent, ElementAddComponent ],
  entryComponents: [ DashboardAddComponent, ElementAddComponent ],
  bootstrap: [ AppComponent ],
  providers: [{ provide: HighchartsStatic, useFactory: highchartsFactory }],
})

export class AppModule {}
