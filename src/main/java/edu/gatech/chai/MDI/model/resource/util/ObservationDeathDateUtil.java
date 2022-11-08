package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class ObservationDeathDateUtil {
	public static final String patientLocationExtensionURL = "http://hl7.org/fhir/us/mdi/StructureDefinition/Extension-observation-location";
	public static final HashSet<CodeableConcept> dateEstablishmentMethods = new HashSet<>(Arrays.asList(
            new CodeableConcept().addCoding(new Coding(MDICommonUtil.mdiCodesSystemURL, "exact", "Exact")),
            new CodeableConcept().addCoding(new Coding(MDICommonUtil.mdiCodesSystemURL, "approximate", "Approximate")),
            new CodeableConcept().addCoding(new Coding(MDICommonUtil.mdiCodesSystemURL, "court-appointed", "Court Appointed"))));
}