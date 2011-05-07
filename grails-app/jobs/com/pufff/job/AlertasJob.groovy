package com.pufff.job

import org.quartz.JobExecutionContext
import com.pufff.domain.user.Alerta


class AlertasJob {

    def alertasMailService

    def execute(JobExecutionContext context) {
        Long idAlerta = context.trigger.jobName as Long
        Alerta alerta = Alerta.get(idAlerta)
        alertasMailService.notificar(alerta)
    }
}
