package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentDispositionMethodUtil;
import edu.gatech.chai.VRDR.model.util.MannerOfDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-manner-of-death")
public class ObservationMannerOfDeath extends Observation {

	public ObservationMannerOfDeath() {
		super();
		CommonUtil.initResource(this);
		setStatus(MannerOfDeathUtil.status);
		setCode(MannerOfDeathUtil.code);
	}

	public ObservationMannerOfDeath(CodeableConcept manner, Patient subject, Practitioner performer) {
		this();
		setValue(manner);
		setSubject(new Reference(subject));
		this.addPerformer(new Reference(performer));
	}
	
	public ObservationMannerOfDeath(String manner, Patient subject, Practitioner performer) {
		this();
		setValue(manner);
		setSubject(new Reference(subject));
		this.addPerformer(new Reference(performer));
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, MannerOfDeathUtil.valueCodesetList);
		if(concept != null) {
			setValue(concept);
		}
	}
	
	public void setValue(String code, String display) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, MannerOfDeathUtil.valueCodesetList);
		if(concept == null) {
			concept = CommonUtil.findConceptFromCollectionUsingSimpleString(display, MannerOfDeathUtil.valueCodesetList);
		}
		if(concept != null) {
			setValue(concept);
		}
	}
}