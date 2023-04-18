package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class MDICommonUtil {
	public static final String mdiCodesSystemURL = "http://hl7.org/fhir/us/mdi/CodeSystem/CodeSystem-mdi-codes";
	public static final String mdiLocalComponentCodesURL = "http://hl7.org/fhir/us/mdi/CodeSystem/CodeSystem-local-component-codes";
	public static final HashSet<CodeableConcept> yesNoUnknownNASKSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "Y", "Yes")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "N", "No")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "ASKU", "asked but unknown")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "NASK", "not asked"))));
	public static final HashSet<CodeableConcept> yesNoNASet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "Y", "Yes")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "N", "No")),
			new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "NA", "not applicable"))));
	public static final String trackingNumberExtensionURL = "http://hl7.org/fhir/us/mdi/StructureDefinition/Extension-tracking-number";
	public static final CodeableConcept trackingNumberMDIType = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"mdi-case-number","MDI Case Number"));
	public static final CodeableConcept trackingNumberEDRSType = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"edrs-file-number","EDRS File Number"));
	public static final CodeableConcept trackingNumberTOXType = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"tox-lab-case-number","Toxicology Laboratory Case Number"));
}
