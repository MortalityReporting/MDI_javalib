# MDI_javalib

Java library implementation of the FHIR MDI Implementation Guide.  This repository includes Java code for:

- Producing and consuming the Medicolegal Death Investigation (MDI) Health Level 7 (HL7) Fast Healthcare Interoperability Resources (FHIR) standard. [Click here to view the FHIR Implementation Guide STU1.0.0](http://hl7.org/fhir/us/mdi/STU1/).
- Producing and consuming FHIR documents for the exchange of MDI-to-EDRS Documents.
- Producing and consuming FHIR messages for the exchange of Tox-To-MDI Messages
- Numerous test cases illustrating proper usage of the library

# Standards

This java library implements the FHIR MDI standard ```http://hl7.org/fhir/us/mdi/STU1/```, explained in the implementation guides below:

* MDI IG: ```http://hl7.org/fhir/us/mdi/STU1/```

# Info

This project uses the hapi-fhir java libraries extensively to create its representation.

It is recommended to have a strong understanding of the resource extension section of the hapi-fhir library before diving into the code. Info can be found here. https://hapifhir.io/hapi-fhir/docs/model/custom_structures.html

This project is made up of several major components:

* ```edu.gatech.MDI.model``` Contains all the custom resources needed for the MDI IG.
* ```edu.gatech.v.model.util``` Contains utility methods like custom codes and static definitions for data structure resources.

You can refer to the ```src/test``` directory for an in-depth unit test example on how to construct a full MDI-to-EDRS record, or a full TOX-to-MDI, and serialize it to JSON

# Build

Build the library using maven:

* ```mvn clean install```

Optionally, build the command line tool using maven command:

* ```mvn clean package appassembler:assemble```
