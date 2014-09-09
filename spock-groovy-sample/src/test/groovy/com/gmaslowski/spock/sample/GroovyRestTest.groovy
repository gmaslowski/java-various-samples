package com.gmaslowski.spock.sample

import groovyx.net.http.RESTClient
import spock.lang.Specification

class GroovyRestTest extends Specification {

    def "should get info about driver"() {

        given:
        def client = new RESTClient("http://ergast.com")

        when:
        def resp = client.get(path: "/api/f1/constructors/mclaren/circuits/monza/drivers/alonso.json")

        then:
        println resp.data
        println resp.data.MRData.DriverTable.Drivers
    }
}