package com.pufff

import com.pufff.domain.trafico.Carretera
import com.pufff.domain.user.Alerta

class HomeController {

    def alertasQuartzService

    def index = {
        //def carreterasList = Carretera.listInOrder()
        //[carreteras: carreterasList]
        def diaSemanaBean = ['L': Calendar.MONDAY, 'M': Calendar.TUESDAY, 'X': Calendar.WEDNESDAY, 'J': Calendar.THURSDAY,
                'F': Calendar.FRIDAY, 'S': Calendar.SATURDAY, 'D': Calendar.SUNDAY]
        return getDefModel()
    }

    private Map getDefModel() {
        def diaSemanaBean = ['L': Calendar.MONDAY, 'M': Calendar.TUESDAY, 'X': Calendar.WEDNESDAY, 'J': Calendar.THURSDAY,
                'F': Calendar.FRIDAY, 'S': Calendar.SATURDAY, 'D': Calendar.SUNDAY]
        return [diaSemanaBean: diaSemanaBean,
                numHoras: 4]
    }

    def createAlerta = {HomeCommand cmd ->
        Carretera carretera = Carretera.findById(cmd.carretera)
        Alerta alerta = new Alerta(carretera: carretera,
            pkInicial: cmd.pkInicial,
            pkFinal: cmd.pkFinal,
            email: cmd.email)
        alertasQuartzService.programar(alerta)
        render(view: "exito", model: [carretera: carretera, cmd: cmd])
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
        email(email: true, nullable:false)
        pkInicial(blank: false, nullable:false)
        pkFinal(blank: false, nullable:false)
        diaSemana(size: 1..7, nullable:false)
    }
}
