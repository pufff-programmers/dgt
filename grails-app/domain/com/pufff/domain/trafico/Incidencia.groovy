package com.pufff.domain.trafico

class Incidencia {
    TipoIncidencia tipo
    Autonomia autonomia
    Provincia provincia
    CausaIncidencia causa
    Poblacion poblacion
    Date dateInicio
    NivelCirculacion nivelCirculacion
    Carretera carretera
    Double pkInicial
    Double pkFinal
    String sentido
    String hacia

    static belongsTo = [parseo:Parseo]

    static constraints = {
        tipo(nullable: true)
        autonomia(nullable: true)
        provincia(nullable: true)
        causa(nullable: true)
        poblacion(nullable: true)
        dateInicio(nullable: false)
        nivelCirculacion(nullable: true)
        carretera(nullable: false)
        pkInicial(nullable: false)
        pkFinal(nullable: false)
        sentido(nullable: true)
        hacia(nullable: true)
    }
}
