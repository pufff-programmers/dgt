package com.pufff

import com.pufff.domain.trafico.Carretera
import com.pufff.domain.user.Alerta

class HomeController {

    def alertasQuartzService

    def index = {
        return getDefModel()
    }

    private Map getDefModel() {
        def diaSemanaBean = ['L': 'MON', 'M': 'TUE', 'X': 'WED', 'J': 'THU',
                'F': 'FRI', 'S': 'SAT', 'D': 'SUN']
        return [diaSemanaBean: diaSemanaBean,
                numHoras: 4]
    }

    def createAlerta = {HomeCommand cmd ->
        if (cmd.hasErrors()) {
            Map model = [cmd: cmd]
            model.putAll(getDefModel())
            render([view: 'index', model: model])
        }
        else {
            Carretera carretera = Carretera.findById(cmd.carretera)
            Alerta alerta = new Alerta(carretera: carretera,
                    pkInicial: cmd.pkInicial,
                    pkFinal: cmd.pkFinal,
                    email: cmd.email,
                    diasSemana: cmd.diaSemana,
                    horas: cmd.horas,
                    minutos: cmd.minutos)
            alerta.save()
            alertasQuartzService.programar(alerta)
            render(view: "exito", model: [carretera: carretera, cmd: cmd])
        }
    }
}


class HomeCommand {
    Integer carretera
    Double pkInicial
    Double pkFinal
    String email
    List diaSemana
    List horas
    List minutos

    static constraints = {
        carretera(nullable: false, blank: false)
        pkInicial(blank: false, nullable: false)
        pkFinal(blank: false, nullable: false)
        //diaSemana(size: 1..7, nullable:false, blank:false)
        email(email: true, blank: false)
    }
}