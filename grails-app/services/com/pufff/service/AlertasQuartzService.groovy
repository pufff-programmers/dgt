package com.pufff.service

import com.pufff.domain.user.Alerta
import com.pufff.domain.user.User
import com.pufff.job.ParserJob
import org.quartz.CronTrigger
import com.pufff.job.AlertasJob

class AlertasQuartzService {

    static transactional = true

    // Programa una tarea nueva en quartz para el envío de alertas
    def programar(User user, Alerta alerta) {
        CronTrigger trigger = new CronTrigger(alerta.id, user.id, buildCronExpression(alerta))
        AlertasJob.schedule(trigger)
    }

    // Edita una tarea programada en quartz para el envío de alertas
    def reprogramar(User user, Alerta alerta) {
        CronTrigger trigger = new CronTrigger(alerta.id, user.id, buildCronExpression(alerta))
        AlertasJob.reschedule(trigger)
    }

    // Cancela una tarea de quartz para el envío de alertas
    def cancelar(User user, Alerta alerta) {
        AlertasJob.unschedule(alerta.id, user.id)
    }

}
