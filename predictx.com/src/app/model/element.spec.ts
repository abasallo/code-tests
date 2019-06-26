import Element from './element'

describe('Element', () => {

  it('Object is properly initialized with full signature', () => {

    const json = { json: "json" }

    const elementFullSignature = new Element(1, 'name', json, 4, 5)

    expect(elementFullSignature.id).toBe(1)
    expect(elementFullSignature.name).toBe('name')
    expect(elementFullSignature.json).toBe(json)
    expect(elementFullSignature.colSpan).toBe(4)
    expect(elementFullSignature.rowSpan).toBe(5)
  })
})
