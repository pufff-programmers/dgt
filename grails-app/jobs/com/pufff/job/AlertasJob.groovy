package com.pufff.job

import com.pufff.domain.user.Alerta
import org.quartz.JobExecutionContext
import org.quartz.Trigger


class AlertasJob {

    def alertasMailService

    def volatility = false

    static triggers = { }

    def execute(JobExecutionContext context) {
        println "Ejecutando alerta!!!"
        Long idAlerta = getAlertId(context.trigger)
        Alerta alerta = Alerta.get(idAlerta)
        alertasMailService.notificar(alerta)
    }

    private def getAlertId(Trigger trigger) {
        String triggerName = trigger.name
        return triggerName.split('_')[0] as Long
    }

}
