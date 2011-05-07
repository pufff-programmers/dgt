package com.pufff.domain.trafico

class Carretera {

    String nombre

    static constraints = {
        nombre(nullable: false)
    }

    String toString() {
        nombre
    }

    static def listInOrder() {
        def lista = Carretera.list()
        Map map = new TreeMap()
        lista.each {
            int i = it.nombre.indexOf('-')
            String justName
            if(i > -1) {
                justName = it.nombre[0..i]
            } else {
                justName = it.nombre
            }
            map.put(justName, it)
        }
        def ret = new ArrayList()
        map.each {
            ret.add(it.value)
        }
        return ret
    }
}
