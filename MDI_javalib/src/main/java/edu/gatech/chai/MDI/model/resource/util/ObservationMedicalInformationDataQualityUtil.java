package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class ObservationMedicalInformationDataQualityUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(
			new Coding(CommonUtil.mdiCodesSystemURL,"med-info-data-quality-obs", "Medical Information Data Quality Observation"));

	public static final CodeableConcept MedicalDataValid = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "MED_INF_DQ_MEDICAL_VALID", "Medical Data Valid"));
	public static final CodeableConcept MedicalDataValidWithExceptions = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "MED_INF_DQ_MEDICAL_VALID_WITH_EXCEPTIONS", "Medical Data Valid With Exceptions"));
	public static final CodeableConcept MedicalDataNotInvalid = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.mdiCodesSystemURL, "MED_INF_DQ_MEDICAL_NOT_INVALID", "Medical Data Not Invalid"));

	public static final HashSet<CodeableConcept> vsMedDqReview = new HashSet<>(Arrays.asList(
			MedicalDataValid,
			MedicalDataValidWithExceptions,
			MedicalDataNotInvalid));

}