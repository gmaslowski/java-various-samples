spring-webmvc-json-sample
=========================

Simple example on how to return different payload type (JSON/XML) based on Accept header.

Samples:
curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/json"
{"name":"simpleName","values":["value1","value2","value3"]}

curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/xml"
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><appEntity><name>simpleName</name><values>value1</values><values>value2</values><values>value3</values></appEntity>