package com.pufff.domain.user

import com.pufff.domain.trafico.Carretera

class Alerta {

    Carretera carretera
    Double pkInicial
    Double pkFinal
    String email

    static constraints = {
        email(email: true)
    }
}
