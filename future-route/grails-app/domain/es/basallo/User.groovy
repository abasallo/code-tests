package es.basallo

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class User {

    String name
    Locale locale

    static hasMany = [reports: Report]

    static constraints = {
        name blank: false
    }

    def addReport(report) {
        if (!this.reports) this.reports = []
        this.reports << report
        this.save()
    }

    def isFrench() {
        locale == new Locale('fr', 'FR')
    }
}
