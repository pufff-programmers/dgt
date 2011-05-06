package com.pufff.domain.trafico

class Provincia {
    String nombre
    String matricula

    static constraints = {
        nombre(nullable: false)
        matricula(nullable: true)
    }
}
