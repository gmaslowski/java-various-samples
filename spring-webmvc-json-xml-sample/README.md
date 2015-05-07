spring-webmvc-json-sample
=========================

Simple example on how to return different payload type (JSON/XML) based on Accept header. 
Additional the project contains integration with JSP and JSF pages.

## Run
Navigate to project and run (Tomcat 7 required due to EL2.2 dependency):
```bash
gradle tomcatRun
```

## Examples
### JSON Payload
```bash
curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/json"
```
```json
{
    "name" : "simpleName",
    "values" : ["value1","value2","value3"]
}
```

### XML Payload
```bash
curl http://localhost:8080/spring-webmvc-json-xml-sample/entity -H "Accept: application/xml"
```
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<appEntity>
    <name>simpleName</name>
    <values>value1</values>
    <values>value2</values>
    <values>value3</values>
</appEntity>
```

### JSP Render
Navigate the browser to: 
```bash
http://localhost:8080/spring-webmvc-json-xml-sample/jsp
```

### JSF Render
Navigate the browser to: 
```bash
http://localhost:8080/spring-webmvc-json-xml-sample/jsf/list.jsf
```