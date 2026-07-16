package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class ObservationPersonalInformationDataQualityUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(
			new Coding(CommonUtil.mdiCodesSystemURL,"personal-info-data-quality-obs", "Personal Information Data Quality Observation"));

	public static final CodeableConcept PersonalValid = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "PER_INF_DQ_PERSONAL_VALID", "Personal Valid"));
	public static final CodeableConcept PersonalValidWithExceptions = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "PER_INF_DQ_PERSONAL_VALID_WITH_EXCEPTIONS", "Personal Valid With Exceptions"));
	public static final CodeableConcept PersonalInvalid = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "PER_INF_DQ_PERSONAL_INVALID", "Personal Valid With Exceptions"));

	public static final HashSet<CodeableConcept> vsPerDqReview = new HashSet<>(Arrays.asList(
			PersonalValid,
			PersonalValidWithExceptions,
			PersonalInvalid));

}
