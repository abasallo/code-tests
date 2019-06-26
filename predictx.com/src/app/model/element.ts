export default class Element {

  id: number
  name: string
  json: object

  colSpan: number
  rowSpan: number

  constructor(id: number, name: string, json: object, colSpan: number, rowSpan: number) {
    this.id = id
    this.name = name
    this.json = json
    this.colSpan = colSpan
    this.rowSpan = rowSpan
  }
}
