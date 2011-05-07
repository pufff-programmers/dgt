package com.pufff

import com.pufff.domain.user.Alerta

class HomeController {

    def index = {
        //def carreterasList = Carretera.listInOrder()
        //[carreteras: carreterasList]
        def alertaInstance = new Alerta()
        alertaInstance.properties = params
        def diaSemanaBean = ['L': Calendar.MONDAY, 'M': Calendar.TUESDAY, 'X': Calendar.WEDNESDAY, 'J': Calendar.THURSDAY,
                'F': Calendar.FRIDAY, 'S': Calendar.SATURDAY, 'D': Calendar.SUNDAY]
        return [alertaInstance: alertaInstance, diaSemanaBean: diaSemanaBean, numHoras: 4]
    }

    def createAlerta = {
        render "alerta creada"
    }
}
