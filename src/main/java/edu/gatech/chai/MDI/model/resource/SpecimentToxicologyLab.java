package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Specimen;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Specimen", profile = "https://fhir.org/fhir/us/mdi/StructureDefinition/Specimen-toxicology-lab")
public class SpecimentToxicologyLab extends Specimen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
