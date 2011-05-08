package com.pufff.domain.user

class TokenController {

    def alertasQuartzService

    def cancelarSuscripcion = {
        def alertas = Alerta.findAllByEmail(params.email)
        alertas.each { alerta ->
            eliminarAlerta(alerta)
        }
    }

    def cancelarAlerta = {
        Alerta alerta = Alerta.findByToken(params.token)
        eliminarAlerta(alerta)
    }

    def usoInadecuado = {
        // TODO
        // ¿podemos recibir correos si se suplanta la identidad de alguien, por ejemplo?
    }

    private def eliminarAlerta(Alerta alerta) {
        if(alerta) {
            try {
                alertasQuartzService.cancelar(alerta)
            } catch(Exception e) {
                log.error 'No he podido cancelar la alerta en quartz, seguramente porque no existe'
            }
            alerta.delete()
        }
    }

}
