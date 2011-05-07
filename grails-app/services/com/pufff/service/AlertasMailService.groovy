package com.pufff.service

import com.pufff.domain.user.Alerta
import com.pufff.domain.trafico.Parseo
import com.pufff.domain.trafico.Incidencia

class AlertasMailService {

    static transactional = true

    def mailService

    def notificar(Alerta alerta) {
        def incidencias = findIncidencias(alerta)
        sendMail(alerta, incidencias)
    }

    private def findIncidencias(Alerta alerta) {
        Parseo parseo = Parseo.findAll().unique()
        def incidenciaCriteria = Incidencia.createCriteria()
        def result = incidenciaCriteria.list {
            and {
                eq('parseo', parseo)
                eq('carretera', alerta.carretera)
                ge('pkInicial', alerta.pkInicial)
                le('pkFinal', alerta.pkFinal)
            }
        }
        return result
    }

    private def sendMail(Alerta alerta, incidencias) {
        sendMail {
            to alerta.email
            subject "Incidencia en ${alerta.carretera.nombre}"
            body(view: "/alerta/notification",
                    model: [alerta: alerta, incidencias: incidencias])
        }
    }

}
