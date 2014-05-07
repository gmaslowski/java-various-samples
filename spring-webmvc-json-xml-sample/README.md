spring-webmvc-json-sample
=========================

Simple example on how to return different payload type (JSON/XML) based on Accept header.

*
```bash
curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/json"
```
```json
{"name":"simpleName","values":["value1","value2","value3"]}
```

*
```bash
curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/xml"
```
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><appEntity><name>simpleName</name><values>value1</values><values>value2</values><values>value3</values></appEntity>
```