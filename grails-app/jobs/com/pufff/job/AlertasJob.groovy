package com.pufff.job

import org.quartz.JobExecutionContext
import com.pufff.domain.user.User
import com.pufff.domain.user.Alerta


class AlertasJob {

    def execute(JobExecutionContext context) {
        Long idAlerta = context.trigger.jobName as Long
        Long idUsuario = context.trigger.jobGroup as Long
        User user = User.get(idUsuario)
        Alerta alerta = Alerta.get(idAlerta)
        // TODO
        // alertasMailService.notificar(user, alerta)
    }
}
