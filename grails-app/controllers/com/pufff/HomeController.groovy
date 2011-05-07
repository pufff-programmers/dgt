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
        if(cmd.hasErrors()) {
            Map model =[cmd: cmd]
            model.putAll(getDefModel())
            render([view:'index', model: model])
        }
        else {
            Carretera carretera = Carretera.findById(cmd.carretera)
            Alerta alerta = new Alerta(carretera: carretera,
                pkInicial: cmd.pkInicial,
                pkFinal: cmd.pkFinal,
                email: cmd.email)
            alertasQuartzService.programar(alerta)
            //flash.message="Creada correctamente alerta en ${carretera.nombre}, kilómetros ${cmd.pkInicial} a ${cmd.pkFinal}, a la dirección ${cmd.email}. Puedes crear más para otras carreteras y/o tramos que utilices habitualmente"
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
        pkInicial(blank: false, nullable:false)
        pkFinal(blank: false, nullable:false)
        //diaSemana(size: 1..7, nullable:false, blank:false)
        email(email: true, blank:false)
    }
}