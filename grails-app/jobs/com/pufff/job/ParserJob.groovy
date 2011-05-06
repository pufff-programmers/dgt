package com.pufff.job


class ParserJob {
    static triggers = {
        simple name:'parserTrigger', startDelay: 10000, repeatInterval: 1000*60*30
    }

    def dgtXmlParserService

    def execute() {
        log.info 'Parseando XML de la dgt'
        dgtXmlParserService.parseDgtXml()
    }
}
