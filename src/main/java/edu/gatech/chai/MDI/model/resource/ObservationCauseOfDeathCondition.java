package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationConditionCauseOfDeathUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-cause-of-death-condition")
public class ObservationCauseOfDeathCondition extends Observation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObservationCauseOfDeathCondition() {
		super();
		CommonUtil.initResource(this);
		this.setCode(ObservationConditionCauseOfDeathUtil.code);
	}
	
	public ObservationCauseOfDeathCondition(Patient patient, Practitioner practitioner) {
		this();
		CommonUtil.initResource(this);
		setPatient(patient);
		addPerformer(practitioner);
	}
	
	public void addPerformer(Practitioner practitioner) {
		Reference reference = new Reference(practitioner);
		addPerformer(reference);
	}

	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient);
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
	
	public Reference getPatient() {
		return subject;
	}
	
	public ObservationComponentComponent setInterval(float decimal, String ageUnit) {
		Quantity quantity = new Quantity();
		quantity.setValue(decimal);
		quantity.setUnit(ageUnit);
		return setInterval(quantity);
	}
	
	public ObservationComponentComponent setInterval(Quantity quantity) {
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(ObservationConditionCauseOfDeathUtil.intervalComponentCode);
		occ.setValue(quantity);
		this.addComponent(occ);
		return occ;
	}

}