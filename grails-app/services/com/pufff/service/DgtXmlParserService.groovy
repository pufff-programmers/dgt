package com.pufff.service

import com.pufff.domain.trafico.TipoIncidencia
import com.pufff.domain.trafico.Autonomia
import com.pufff.domain.trafico.Provincia
import com.pufff.domain.trafico.CausaIncidencia
import com.pufff.domain.trafico.Poblacion
import java.text.SimpleDateFormat
import com.pufff.domain.trafico.NivelCirculacion
import com.pufff.domain.trafico.Carretera
import com.pufff.domain.trafico.Incidencia
import com.pufff.domain.trafico.Parseo

class DgtXmlParserService {

     static transactional = true

    def parseDgtXml() {
        def xmlSource = "http://www.dgt.es/incidencias.xml".toURL()
        def raiz = new XmlSlurper().parseText(xmlSource.text)
        def incidencias = raiz.incidencia.list()
        Parseo parseo = new Parseo(dateParseo: new Date(), dateXml: new Date())
        incidencias.each {
            try {
                Incidencia incidencia = parseIncidencia(it)
                parseo.addToIncidencias(incidencia)
            } catch(Exception e) {
                log.error('No he podido parsear una incidencia... no se puede tener todo en la vida, no?', e)
            }
        }
        parseo.save()
        //Añadimos borrado de todos los parseos anteriores al último mes ... y de sus incidencias asociadas
        deleteOldLoads()
    }

    private void deleteOldLoads() {
        Calendar cal = Calendar.instance
        cal.set(Calendar.MONTH, -1)
        Collection<Parseo> result = Parseo.findAllByDateParseoLessThan(cal.time)
        result.each {
            it.delete()
        }
        log.info("Borrados ${result.size()} registros antiguos de Parseo (y sus incidencias asociadas)")
    }

    private Incidencia parseIncidencia(incidenciaXml) {
        TipoIncidencia tipo = TipoIncidencia.findByDescription(incidenciaXml.tipo.text()) ?: new TipoIncidencia(description: incidenciaXml.tipo.text()).save()
        Autonomia autonomia = Autonomia.findByNombre(incidenciaXml.autonomia.text()) ?: new Autonomia(nombre: incidenciaXml.autonomia.text()).save()
        Provincia provincia = Provincia.findByNombre(incidenciaXml.provincia.text()) ?: new Provincia(nombre: incidenciaXml.provincia.text(), matricula: incidenciaXml.matricula.text()).save()
        CausaIncidencia causa = CausaIncidencia.findByDescription(incidenciaXml.causa.text()) ?: new CausaIncidencia(description: incidenciaXml.causa.text()).save()
        Poblacion poblacion = Poblacion.findByNombre(incidenciaXml.poblacion.text()) ?: new Poblacion(nombre: incidenciaXml.poblacion.text()).save()
        Date dateInicio = new SimpleDateFormat('yyyy-MM-dd hh:mm').parse(incidenciaXml.fechahora_ini.text())
        NivelCirculacion nivel = NivelCirculacion.findByDescription(incidenciaXml.nivel.text()) ?: new NivelCirculacion(description: incidenciaXml.nivel.text()).save()
        Carretera carretera = Carretera.findByNombre(incidenciaXml.carretera.text()) ?: new Carretera(nombre: incidenciaXml.carretera.text()).save()
        Double pkInicial = incidenciaXml.pk_inicial.text() as Double
        Double pkFinal = incidenciaXml.pk_final.text() as Double
        String sentido = incidenciaXml.sentido.text()
        String hacia = incidenciaXml.hacia.text()
        Incidencia incidencia = new Incidencia(tipo: tipo, autonomia: autonomia, provincia: provincia, causa: causa, poblacion: poblacion,
                dateInicio: dateInicio, nivelCirculacion: nivel, carretera: carretera, pkInicial: pkInicial,
                pkFinal: pkFinal, sentido: sentido, hacia: hacia)
        return incidencia
    }
}
