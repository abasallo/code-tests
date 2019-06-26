import Common from './common'
import Dashboard from './dashboard'

describe('Common', () => {

  it('From a list, returns next id value with defaults', () => {

    const common = new Common()
    const firstDashboard = new Dashboard(665, 'name', [])
    const list = [ firstDashboard ]

    expect(common.nextId(list)).toBe(666)
    expect(common.nextId([])).toBe(1)
  })
})
