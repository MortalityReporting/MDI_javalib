package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.TobaccoUseContributedToDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-tobacco-use-contributed-to-death")
public class ObservationTobaccoUseContributedToDeath extends Observation {
	public ObservationTobaccoUseContributedToDeath() {
		super();
		setStatus(TobaccoUseContributedToDeathUtil.status);
		setCode(TobaccoUseContributedToDeathUtil.code);
	}
	
	public ObservationTobaccoUseContributedToDeath(CodeableConcept code) {
		this();
		setValue(code);
	}
	
	public ObservationTobaccoUseContributedToDeath(String code) {
		this();
		setValue(code);
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, TobaccoUseContributedToDeathUtil.valueCodesetList);
		if(concept != null) {
			setValue(concept);
		}
	}
}