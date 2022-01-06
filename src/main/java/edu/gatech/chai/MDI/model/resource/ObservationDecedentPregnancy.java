package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationDeathInjuryAtWorkUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationDecedentPregnancyUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;
import edu.gatech.chai.VRDR.model.util.InjuryIncidentUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-decedent-pregnancy")
public class ObservationDecedentPregnancy extends Observation {

	public ObservationDecedentPregnancy() {
		super();
		setCode(ObservationDecedentPregnancyUtil.code);
	}

	public ObservationDecedentPregnancy(Patient subject, CodeableConcept value) {
		this();
		Reference ref = new Reference(subject.getId());
		setSubject(ref);
		setValue(value);
	}
	
	public ObservationDecedentPregnancy(Patient subject, String value) {
		this();
		CodeableConcept valueCode = CommonUtil.findConceptFromCollectionUsingSimpleString(value, ObservationDecedentPregnancyUtil.valueSet);
		Reference ref = new Reference(subject.getId());
		setSubject(ref);
		setValue(valueCode);
	}
}