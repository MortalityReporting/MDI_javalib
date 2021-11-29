package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Observation", profile = "https://fhir.org/fhir/us/mdi/StructureDefinition/OrganWeight")
public class OrganWeight extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
