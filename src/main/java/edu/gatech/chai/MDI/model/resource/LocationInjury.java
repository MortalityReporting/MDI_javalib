package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.LocationInjuryUtil;

@ResourceDef(name = "Location", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Location-injury")
public class LocationInjury extends Location {

	public LocationInjury() {
		super();
		addType(LocationInjuryUtil.type);
	}

}