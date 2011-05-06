package com.pufff.domain.trafico

class Parseo {
    Date dateParseo
    Date dateXml
    static hasMany = [incidencias: Incidencia]

    static constraints = {
        dateParseo(nullable: false)
        dateXml(nullable: false)
    }
}