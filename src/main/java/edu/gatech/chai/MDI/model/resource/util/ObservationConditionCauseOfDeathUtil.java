package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class ObservationConditionCauseOfDeathUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"69453-9", ""));
	public static final CodeableConcept intervalComponentCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"69440-6", ""));
	public HashSet<String> ageUnitSet = new HashSet<String>(Arrays.asList("min","d","h","mo","a"));
}
