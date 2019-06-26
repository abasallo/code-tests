import { TestBed, inject } from '@angular/core/testing'

import { DashboardsService } from './dashboards.service'

describe('DashboardsService', () => {

  beforeEach(() => TestBed.configureTestingModule({ providers: [DashboardsService] }))

  it('should be properly created and injected', inject([ DashboardsService ], (service: DashboardsService) => expect(service).toBeTruthy()))

  it('Data must be properly initialized', inject([ DashboardsService ], (service: DashboardsService) => {

    expect(service.dashboards.selected.name).toBe('Dashboard I')
    expect(service.dashboards.list.length).toBe(4)
    expect(service.dashboards.list[2].elements.length).toBe(3)
    expect(service.dashboards.list[2].elements[2].name).toBe('Element III')
  }))
})
