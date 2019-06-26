import Dashboards from './dashboards'
import Dashboard from './dashboard'

describe('Dashboards', () => {

  const firstDashboard = new Dashboard(-1, 'name1', [])
  const dashboards = new Dashboards([ firstDashboard ])

  it('Object is properly initialized with full signature', () => {

    expect(dashboards.list[0].id).toBe(-1)
    expect(dashboards.selected.id).toBe(-1)
  })

  it('Dashboard is added to the existing list and selected', () => {

    dashboards.add('otherName', 8)

    expect(dashboards.list[1].id).toBe(0)
    expect(dashboards.list[1].name).toBe('otherName')
    expect(dashboards.list[1].elements.length).toBe(0)
    expect(dashboards.list[1].columns).toBe(8)
    expect(dashboards.selected.id).toBe(0)
    expect(dashboards.selected.name).toBe('otherName')
  })
})
