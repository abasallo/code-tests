import Dashboard from './dashboard'
import Common from './common'

export default class Dashboards extends Common {

  selected: Dashboard
  list: Dashboard[]

  constructor(list: Dashboard[]) {
    super()
    this.list = list
    if (list.length > 0) this.selected = list[0]
  }

  add(name: string, columns: number) {
    const dashboard = new Dashboard(this.nextId(this.list), name, [], columns)
    this.list.push(dashboard)
    this.selected = dashboard
  }
}
