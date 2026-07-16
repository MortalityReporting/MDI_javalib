package edu.gatech.chai.MDI.model.resource;

import java.util.ArrayList;
import java.util.Arrays;

import org.hl7.fhir.r4.model.Organization;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.OrganizationCrematoriumUtil;

@ResourceDef(name = "Organization", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Organization-crematorium")
public class OrganizationCrematorium extends Organization {
	public OrganizationCrematorium() {
		super();
		this.setType(new ArrayList<>(Arrays.asList(OrganizationCrematoriumUtil.code)));
	}
	
	public OrganizationCrematorium(String name) {
		super();
		this.setType(new ArrayList<>(Arrays.asList(OrganizationCrematoriumUtil.code)));
		this.setName(name);
	}
}
