package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationCommunicableDiseaseUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-communicable-disease")
public class ObservationCommunicableDisease extends Observation {
	public ObservationCommunicableDisease() {
		super();
		this.setCode(ObservationCommunicableDiseaseUtil.code);
	}
	
	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient);
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
	
	public Reference getSubject() {
		return subject;
	}
}
