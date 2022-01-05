package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationDeathInjuryAtWorkUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;
import edu.gatech.chai.VRDR.model.util.InjuryIncidentUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-death-injury-at-work")
public class ObservationDeathInjuryAtWork extends Observation {

	public ObservationDeathInjuryAtWork() {
		super();
		setCode(ObservationDeathInjuryAtWorkUtil.code);
	}

	public ObservationDeathInjuryAtWork(Patient subject, CodeableConcept value) {
		this();
		Reference ref = new Reference(subject);
		setSubject(ref);
		setValue(value);
	}
	
	public ObservationDeathInjuryAtWork(Patient subject, String value) {
		this();
		CodeableConcept valueCode = CommonUtil.findConceptFromCollectionUsingSimpleString(value, CommonUtil.yesNoNASet);
		Reference ref = new Reference(subject);
		setSubject(ref);
		setValue(valueCode);
	}
}