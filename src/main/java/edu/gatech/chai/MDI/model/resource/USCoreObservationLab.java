package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.USCoreObservationLabUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-observation-lab")
public class USCoreObservationLab extends Observation{
	public USCoreObservationLab(CodeableConcept resultCode, Patient subject) {
		addCategory(USCoreObservationLabUtil.category);
		setCode(resultCode);
		setSubject(new Reference(subject.getId()));
	}
	public Observation setDataAbsentReason(String code) {
		CodeType codeType = CommonUtil.findCodeFromCollectionUsingSimpleString(code, CommonUtil.dataAbsentReasonCodeSet);
		CodeableConcept codeableConcept = new CodeableConcept().addCoding(new Coding(
				codeType.getCode(),codeType.getSystem(),codeType.getDisplay()));
		return setDataAbsentReason(codeableConcept);
	}
}