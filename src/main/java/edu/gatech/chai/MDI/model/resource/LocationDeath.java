package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.LocationDeathUtil;

@ResourceDef(name = "Location", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Location-death")
public class LocationDeath extends Location {

	public LocationDeath() {
		super();
		addType(LocationDeathUtil.type);
	}

}