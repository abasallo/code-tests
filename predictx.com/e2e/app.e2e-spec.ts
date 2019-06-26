import { PiChallengePage } from './app.po'

describe('PI Challenge App', () => {

  let page: PiChallengePage

  beforeEach(() => {
    page = new PiChallengePage()
    page.navigateTo()
  })

  it('Should display initial page properly populated', () => {

    expect(page.getTitle()).toBe('PI Challenge')

    expect(page.getToolbarTitle()).toBe('PI Challenge')

    expect(page.getDashboardList().get(0).getText()).toBe('Dashboard I')
    expect(page.getDashboardList().get(1).getText()).toBe('Dashboard II')
    expect(page.getDashboardList().get(2).getText()).toBe('Dashboard III')
    expect(page.getDashboardList().get(3).getText()).toBe('Dashboard IV')

    expect(page.getElementList().get(0).getText()).toBe('Element I')

    expect(page.getElementShow().count()).toBe(1)
  })

  it('Should be possible to add new Dashboards', () => {

    page.getAddDashboardButton().click()
    page.getAddDashboardDialogInputName().sendKeys('Dashboard V')
    page.getAddDashboardDialogInputColumns().sendKeys('2')
    page.getAddDashboardDialogButtonOk().click()

    expect(page.getDashboardList().get(4).getText()).toBe('Dashboard V')
    expect(page.getDashboardList().count()).toBe(5)
    expect(page.getElementList().count()).toBe(0)
    expect(page.getElementShow().count()).toBe(0)

    page.getAddElementButton().click()
    page.getAddElementDialogInputName().sendKeys('Element I')
    page.getAddElementDialogButtonOk().click()

    expect(page.getDashboardList().get(4).getText()).toBe('Dashboard V')
    expect(page.getDashboardList().count()).toBe(5)
    expect(page.getElementList().get(0).getText()).toBe('Element I')
    expect(page.getElementList().count()).toBe(1)
    expect(page.getElementShow().count()).toBe(1)
  })
})
