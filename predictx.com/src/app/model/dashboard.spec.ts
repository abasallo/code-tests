import Dashboard from './dashboard'

describe('Dashboard', () => {

  const fullSignatureDashboard = new Dashboard(-1, 'name', [], 8)
  const minimalSignatureDashboard = new Dashboard(-2, 'otherName', [])

  it('Object is properly initialized with full signature', () => {

    expect(fullSignatureDashboard.id).toBe(-1)
    expect(fullSignatureDashboard.name).toBe('name')
    expect(fullSignatureDashboard.elements.length).toBe(0)
    expect(fullSignatureDashboard.columns).toBe(8)
    expect(fullSignatureDashboard.gutterSizePixels).toBe(5)
    expect(fullSignatureDashboard.rowHeight).toBe('450px')
  })

  it('Object is properly initialized with defaults', () => {

    expect(minimalSignatureDashboard.id).toBe(-2)
    expect(minimalSignatureDashboard.name).toBe('otherName')
    expect(minimalSignatureDashboard.elements.length).toBe(0)
    expect(minimalSignatureDashboard.columns).toBe(2)
  })

  it('Element is added to the existing list', () => {

    const jsonObject = { json: 'json' }
    fullSignatureDashboard.addElement('elementName', jsonObject, 1, 2)

    expect(fullSignatureDashboard.elements[0].id).toBe(1)
    expect(fullSignatureDashboard.elements[0].name).toBe('elementName')
    expect(fullSignatureDashboard.elements[0].json).toBe(jsonObject)
    expect(fullSignatureDashboard.elements[0].colSpan).toBe(1)
    expect(fullSignatureDashboard.elements[0].rowSpan).toBe(2)
  })
})
