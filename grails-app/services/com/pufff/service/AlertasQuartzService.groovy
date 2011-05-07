package com.pufff.service

import com.pufff.domain.user.Alerta
import org.quartz.CronTrigger
import com.pufff.job.AlertasJob
import com.pufff.quartz.CronExpression

class AlertasQuartzService {

    static transactional = true

    // Programa una tarea nueva en quartz para el envío de alertas
    def programar(Alerta alerta) {
        def cronExpressions = buildCronExpression(alerta)
        cronExpressions.each { String cronExpression ->
            CronTrigger trigger = new CronTrigger(jobName: alerta.id as String, jobGroup: alerta.email, cronExpression: cronExpression)
            AlertasJob.schedule(trigger)
        }
    }

    // Cancela una tarea de quartz para el envío de alertas
    def cancelar(Alerta alerta) {
        AlertasJob.unschedule(alerta.id, alerta.email)
    }

    private def buildCronExpression(Alerta alerta) {
        def cronExpressions = []
        alerta.diasSemana.each {dia ->
            alerta.horas.eachWithIndex {String hora, index ->
                if(!hora.isEmpty()) {
                    CronExpression expression = new CronExpression(minute: alerta.minutos[index] as Integer, hour: hora as Integer, dayOfWeek: dia)
                    cronExpressions << expression.value()
                }
            }
        }
        return cronExpressions
    }

}
