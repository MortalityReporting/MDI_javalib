package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class ObservationDecedentPregnancyUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"69442-2","Timing of recent pregnancy in relation to death"));
	public static final CodeableConcept VALUE_NOCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1260").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant within past year"));
	public static final CodeableConcept VALUE_YESCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1261").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Pregnant at the time of death"));
	public static final CodeableConcept VALUE_42DAYSCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1262").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant, but pregnant within 42 days of death"));
	public static final CodeableConcept VALUE_1YEARCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1263").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant, but pregnant 43 days to 1 year before death"));
	public static final CodeableConcept VALUE_UNKNOWNCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1264").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Unknown if pregnant within the past year"));
	public static final HashSet<CodeableConcept> valueSet = new HashSet<>(Arrays.asList(
			VALUE_NOCODE,VALUE_YESCODE,VALUE_42DAYSCODE,VALUE_1YEARCODE,VALUE_UNKNOWNCODE,CommonUtil.notApplicableCode));
}