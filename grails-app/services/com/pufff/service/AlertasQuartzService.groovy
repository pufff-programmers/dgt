package com.pufff.service

import com.pufff.domain.user.Alerta
import org.quartz.CronTrigger
import com.pufff.job.AlertasJob

class AlertasQuartzService {

    static transactional = true

    // Programa una tarea nueva en quartz para el envío de alertas
    def programar(Alerta alerta) {
        CronTrigger trigger = new CronTrigger(alerta.id, alerta.email, buildCronExpression(alerta))
        AlertasJob.schedule(trigger)
    }

    // Edita una tarea programada en quartz para el envío de alertas
    def reprogramar(Alerta alerta) {
        CronTrigger trigger = new CronTrigger(alerta.id, alerta.email, buildCronExpression(alerta))
        AlertasJob.reschedule(trigger)
    }

    // Cancela una tarea de quartz para el envío de alertas
    def cancelar(Alerta alerta) {
        AlertasJob.unschedule(alerta.id, alerta.email)
    }

    private String buildCronExpression(Alerta alerta) {
        // TODO
        return ''
    }

}
