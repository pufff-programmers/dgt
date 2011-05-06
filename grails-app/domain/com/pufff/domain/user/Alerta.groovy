package com.pufff.domain.user

import com.pufff.domain.trafico.Carretera

class Alerta {

    static belongsTo = [user:User]

    Carretera carretera
    Double pkInicial
    Double pkFinal

    static constraints = {
    }
}
