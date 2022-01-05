package edu.gatech.chai.MDI.model.resource.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class DocumentReferenceMDICaseNotesSummaryUtil {
	public static final CodeableConcept type = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"47046-8","Summary of death note"));
	public static final CodeableConcept category = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"mdi-case-notes-summary","MDI Case Notes Summary"));
}
