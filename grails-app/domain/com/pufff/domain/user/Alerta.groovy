package com.pufff.domain.user

import com.pufff.domain.trafico.Carretera

class Alerta {


    Carretera carretera
    Double pkInicial
    Double pkFinal
    String email

    List diasSemana
    List horas
    List minutos

    String token = System.currentTimeMillis()

    static constraints = {
        email(email: true)
    }

    static transients = ['diasSemana', 'horas', 'minutos']
}
