package com.pufff

import com.pufff.domain.trafico.Carretera
import com.pufff.domain.user.Alerta
import com.pufff.domain.trafico.Incidencia

class HomeController {

    def alertasQuartzService
    def incidenciasService

    def index = {
        return getDefModel()
    }

    private Map getDefModel() {
        def diaSemanaBean = ['L': 'MON', 'M': 'TUE', 'X': 'WED', 'J': 'THU',
                'F': 'FRI', 'S': 'SAT', 'D': 'SUN']
        return [diaSemanaBean: diaSemanaBean,
                numHoras: 4]
    }

    private void renderValidationErrors(def cmd) {
        Map model = [cmd: cmd]
        model.putAll(getDefModel())
        render([view: 'index', model: model])
    }

    def goRss = {
        HomeCommand cmd ->
        boolean carreteraOk=cmd.carretera!= null
        boolean pksOk = cmd.pkInicial!= null && cmd.pkFinal!= null
        if(!carreteraOk||!pksOk) {
            renderValidationErrors(cmd)
        } else {
            redirect(action: "showRss", params: [carretera: cmd.carretera, pkInicial: cmd.pkInicial, pkFinal: cmd.pkFinal])
        }
    }

    def showRss = {
        render(feedType:"rss", feedVersion:"2.0") {
            Carretera carr = Carretera.findById(params.carretera)
            title = "Mis incidencias en la ${carr.nombre}"
            link = "#"
            description = """Feed en tiempo real con las incidencias entre los kilómetros ${params.pkInicial}
                y ${params.pkFinal} de la ${carr.nombre}. Información obtenida de la DGT (www.dgt.es)"""
            def incidencias = incidenciasService.findIncidencias(carr, params.pkInicial as Double, params.pkFinal as Double)
            incidencias.each {incidencia ->
                entry("${incidencia.tipo.description} en ${incidencia.poblacion.nombre} (${incidencia.provincia.nombre})") {
                    link = "http://www.dgt.es/"
                    publishedDate = incidencia.dateInicio
                    content(type:'text/html',
                            value: getIncidenciaBody(incidencia))
                }
            }
        }
    }

    private String getIncidenciaBody(Incidencia incidencia) {
        String imgName = null;
        if(incidencia.nivelCirculacion.description?.trim().equalsIgnoreCase('negro')) {
            imgName='blackCircle.jpg'
        } else if(incidencia.nivelCirculacion.description?.trim().equalsIgnoreCase('rojo')) {
            imgName='redCircle.jpg'
        } else if(incidencia.nivelCirculacion.description?.trim().equalsIgnoreCase('verde')) {
            imgName='greenCircle.jpg'
        } else if(incidencia.nivelCirculacion.description?.trim().equalsIgnoreCase('amarillo')) {
            imgName='yellowCircle.jpg'
        }
        StringBuilder ret = new StringBuilder()
        if(imgName!=null) {
            ret.append("<img src=\'/dgt/images/${imgName}\'/>&nbsp;")
        }
        ret.append(buildIncidenciaBodyPart(incidencia?.nivelCirculacion?.description, 'Nivel '))
        ret.append(buildIncidenciaBodyPart(incidencia?.causa?.description, 'debido a '))
        ret.append(buildIncidenciaBodyPart(incidencia?.sentido, 'en sentido '))
        ret.append(buildIncidenciaBodyPart(incidencia?.hacia, 'hacia '))
        return ret
    }

    private String buildIncidenciaBodyPart(String prop, String prefix) {
        if(prop) {
            prefix+prop+' '
        }
        else {
            ' '
        }
    }

    def createAlerta = {HomeCommand cmd ->
        if (cmd.hasErrors()) {
            renderValidationErrors(cmd)
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
    Boolean isRss

    static constraints = {
        carretera(nullable: false, blank: false)
        pkInicial(blank: false, nullable: false)
        pkFinal(blank: false, nullable: false)
        //diaSemana(size: 1..7, nullable:false, blank:false)
        email(email: true, blank: false)
    }
}