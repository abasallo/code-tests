import Common from './common'

import { environment } from '../../environments/environment'

import Element from './element'

export default class Dashboard extends Common {

  id: number
  name: string
  elements: Element[]

  columns: number = environment.common.defaults.dashboard.columns
  gutterSizePixels: number = environment.common.defaults.dashboard.gutterSizePixels
  rowHeight: string = environment.common.defaults.dashboard.rowHeight

  constructor(id: number, name: string, elements: Element[], columns?: number) {
    super()
    this.id = id
    this.name = name
    this.elements = elements
    if (columns) this.columns = columns
  }

  addElement(name: string, json: object, colspan: number, rowspan: number) {
    this.elements.push(new Element(this.nextId(this.elements), name, json, colspan, rowspan))
  }
}
