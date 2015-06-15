sbt-sample-tests
================

Running multiple-level tests using SBT. Tests are written in Java.
 
### All levels in order: Unit -> Integration -> End2End
```
sbt test-all
```

### Only Unit tests
```
sbt test
```

### Only Integration tests 
```
sbt integration:test
```

### Only End2End tests
```
sbt e2e:test
```
