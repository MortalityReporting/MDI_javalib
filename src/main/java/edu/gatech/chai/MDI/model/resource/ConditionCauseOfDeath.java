package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Condition-cause-of-death")
public class ConditionCauseOfDeath extends Condition{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConditionCauseOfDeath() {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
	}
	
	public ConditionCauseOfDeath(Patient patient) {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setPatient(patient);
	}
	
	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient.getId());
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
	
	public Reference getPatient() {
		return subject;
	}
	
	public void setPractitioner(Practitioner practitioner) {
		Reference reference = new Reference(practitioner.getId());
		this.asserter = reference;
	}
	public void setAsserter(Practitioner practitioner) {
		setPractitioner(practitioner);
	}
	
	public Reference getPractitioner() {
		return asserter;
	}
	
	public Condition setClinicalStatus(String clinicalStatus) {
		CodeableConcept clinicalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(clinicalStatus, CauseOfDeathConditionUtil.conditionClinicalStatusSet);
		this.setClinicalStatus(clinicalStatusCC);
		return this;
	}
	
	public Condition setVerificationStatus(String verificationStatus) {
		CodeableConcept verificationStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(verificationStatus, CauseOfDeathConditionUtil.verificationStatusSet);
		this.setVerificationStatus(verificationStatusCC);
		return this;
	}
	
}