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
        Alerta alerta = Alerta.findAllByToken(params.token)
        eliminarAlerta(alerta)
    }

    def usoInadecuado = {
        // TODO
        // ¿podemos recibir correos si se suplanta la identidad de alguien, por ejemplo?
    }

    private def eliminarAlerta(Alerta alerta) {
        if(alerta) {
            alertasQuartzService.cancelar(alerta)
            alerta.delete()
        }
    }

}
