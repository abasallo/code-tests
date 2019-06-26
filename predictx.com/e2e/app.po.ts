import { browser, by, element } from 'protractor'

export class PiChallengePage {

  navigateTo() {
    return browser.get('/')
  }

  getTitle() {
    return browser.getTitle()
  }

  getToolbarTitle() {
    return element(by.id('toolbar-title')).getText()
  }

  getDashboardList() {
    return element.all(by.id('dashboard-list-item'))
  }

  getElementList() {
    return element.all(by.id('element-list-item'))
  }

  getElementShow() {
    return element.all(by.id('element-show-item'))
  }

  getAddDashboardButton() {
    return element(by.id('dashboard-add-button'))
  }

  getAddElementButton() {
    return element(by.id('element-add-button'))
  }

  getAddDashboardDialogInputName() {
    return element(by.id('dashboard-add-dialog-name'))
  }

  getAddDashboardDialogInputColumns() {
    return element(by.id('dashboard-add-dialog-columns'))
  }

  getAddDashboardDialogButtonOk() {
    return element(by.id('dashboard-add-dialog-button-ok'))
  }

  getAddElementDialogInputName() {
    return element(by.id('element-add-dialog-name'))
  }

  getAddElementDialogButtonOk() {
    return element(by.id('element-add-dialog-button-ok'))
  }
}
