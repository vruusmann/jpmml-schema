JPMML-Schema
============

Java command-line application for extracting "model schema information" from a PMML file, and saving it into a JSON file.

# Installation #

Build using Apache Maven:
```
mvn clean install
```

The build prodices an executable uber-JAR file `target/jpmml-schema-executable-1.0-SNAPSHOT.jar`.

# Usage #

The application class `org.jpmml.schema.Main` takes exactly two arguments - the path to the PMML input file, and the path to the Model Schema-as-JSON output file.

For example, processing the sample file `src/etc/DecisionTreeIris.pmml`:
```
java -jar target/jpmml-schema-executable-1.0-SNAPSHOT.jar src/etc/DecisionTreeIris.pmml DecisionTreeIris.json
```
