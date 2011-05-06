package com.pufff.domain.user

class AlertaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [alertaInstanceList: Alerta.list(params), alertaInstanceTotal: Alerta.count()]
    }

    def create = {
        def alertaInstance = new Alerta()
        alertaInstance.properties = params
        return [alertaInstance: alertaInstance]
    }

    def save = {
        def alertaInstance = new Alerta(params)
        if (alertaInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'alerta.label', default: 'Alerta'), alertaInstance.id])}"
            redirect(action: "show", id: alertaInstance.id)
        }
        else {
            render(view: "create", model: [alertaInstance: alertaInstance])
        }
    }

    def show = {
        def alertaInstance = Alerta.get(params.id)
        if (!alertaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
            redirect(action: "list")
        }
        else {
            [alertaInstance: alertaInstance]
        }
    }

    def edit = {
        def alertaInstance = Alerta.get(params.id)
        if (!alertaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [alertaInstance: alertaInstance]
        }
    }

    def update = {
        def alertaInstance = Alerta.get(params.id)
        if (alertaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (alertaInstance.version > version) {
                    
                    alertaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'alerta.label', default: 'Alerta')] as Object[], "Another user has updated this Alerta while you were editing")
                    render(view: "edit", model: [alertaInstance: alertaInstance])
                    return
                }
            }
            alertaInstance.properties = params
            if (!alertaInstance.hasErrors() && alertaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'alerta.label', default: 'Alerta'), alertaInstance.id])}"
                redirect(action: "show", id: alertaInstance.id)
            }
            else {
                render(view: "edit", model: [alertaInstance: alertaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def alertaInstance = Alerta.get(params.id)
        if (alertaInstance) {
            try {
                alertaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'alerta.label', default: 'Alerta'), params.id])}"
            redirect(action: "list")
        }
    }
}
