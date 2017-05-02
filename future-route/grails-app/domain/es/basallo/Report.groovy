package es.basallo

import groovy.transform.EqualsAndHashCode
import groovy.transform.Synchronized
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Report {

    private static Integer numberOfActiveGenerations = 0

    String name

    static belongsTo = [user: User]

    static constraints = {
        name blank: false
    }

    static transients = ['numberOfActiveGenerations']

    @Synchronized
    static void setNumberOfActiveGenerations(numberOfActiveGenerations) {
        this.numberOfActiveGenerations = numberOfActiveGenerations
    }

    @Synchronized
    static Integer getNumberOfActiveGenerations() {
        this.numberOfActiveGenerations
    }
}
