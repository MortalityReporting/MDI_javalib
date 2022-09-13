package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationTobaccoUseContributedToDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-tobacco-use-contributed-to-death")
public class ObservationTobaccoUseContributedToDeath extends Observation {
	public ObservationTobaccoUseContributedToDeath() {
		super();
		setStatus(ObservationTobaccoUseContributedToDeathUtil.status);
		setCode(ObservationTobaccoUseContributedToDeathUtil.code);
	}
	
	public ObservationTobaccoUseContributedToDeath(Patient patient, CodeableConcept code) {
		this();
		setSubject(new Reference(patient));
		setValue(code);
	}
	
	public ObservationTobaccoUseContributedToDeath(Patient patient, String code) {
		this();
		setSubject(new Reference(patient));
		setValue(code);
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, ObservationTobaccoUseContributedToDeathUtil.valueCodesetList);
		if(concept != null) {
			setValue(concept);
		}
	}
}