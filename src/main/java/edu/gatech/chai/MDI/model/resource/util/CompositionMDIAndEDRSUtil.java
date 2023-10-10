package edu.gatech.chai.MDI.model.resource.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class CompositionMDIAndEDRSUtil {
	public static final CodeableConcept type = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"86807-5","Death administrative information Document"));
	public static final CodeableConcept demographicsSectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"demographics", ""));
	public static final CodeableConcept circumstancesSectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"circumstances",""));
	public static final CodeableConcept jurisdictionSectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"jurisdiction",""));
	public static final CodeableConcept causeMannerSectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"cause-manner",""));
	public static final CodeableConcept medicalHistorySectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"medical-history",""));
	public static final CodeableConcept examAutopsySectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"exam-autopsy",""));
	public static final CodeableConcept narrativeSectionCode = new CodeableConcept().addCoding(
			new Coding(MDICommonUtil.mdiCodesSystemURL,"narratives",""));
	
}