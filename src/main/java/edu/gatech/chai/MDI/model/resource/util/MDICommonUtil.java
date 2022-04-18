package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class MDICommonUtil {
	public static final String mdiCodesSystemURL = "http://hl7.org/fhir/us/mdi/CodeSystem/CodeSystem-mdi-codes";
	public static final HashSet<CodeableConcept> yesNoNASet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "Y", "Yes")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "N", "No")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "NA", "not applicable"))));
}
