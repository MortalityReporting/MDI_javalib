package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.ConditionContributingToDeathUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Condition-other-contributing-to-death")
public class ConditionOtherContributingToDeath extends Condition {
	public ConditionOtherContributingToDeath() {
		super();
		this.addCategory(ConditionContributingToDeathUtil.conditionContributingToDeathCategory);
	}
	
	public ConditionOtherContributingToDeath(Patient patient) {
		super();
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setPatient(patient);
	}
	
	public ConditionOtherContributingToDeath(Practitioner practitioner) {
		super();
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setPractitioner(practitioner);
	}
	
	public ConditionOtherContributingToDeath(Patient patient, Practitioner practitioner) {
		super();
		setPatient(patient);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setPractitioner(practitioner);
	}
	
	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient.getId());
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
	
	public Reference getSubject() {
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
}
