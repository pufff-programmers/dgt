package com.pufff.service

import com.pufff.domain.trafico.Carretera
import com.pufff.domain.trafico.Parseo
import com.pufff.domain.trafico.Incidencia
import org.springframework.transaction.annotation.Transactional

class IncidenciasService {

    static transactional = true

    @Transactional(readOnly = true)
    def findIncidencias(Carretera carr, Double pkInicial, Double pkFinal) {
        //Encontramos último parseo
        def parseos = Parseo.list(sort: 'id')
        Parseo parseo = parseos.last()
        def incidenciaCriteria = Incidencia.createCriteria()
        def listaIncidencias = incidenciaCriteria.list {
            and {
                eq('parseo', parseo)
                eq('carretera', carr)
                ge('pkInicial', pkInicial)
                le('pkFinal', pkFinal)
            }
        }
        listaIncidencias.sort()
        return listaIncidencias
    }

    /*def incidenciaCriteria = Incidencia.createCriteria()
        def result = incidenciaCriteria.list {
            and {
                eq('parseo', parseo)
                eq('carretera', alerta.carretera)
                ge('pkInicial', alerta.pkInicial)
                le('pkFinal', alerta.pkFinal)
            }
        }*/
}
