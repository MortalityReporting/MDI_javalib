package edu.gatech.chai.MDI.model.resource.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Resource;

public class CommonUtil {
	public static final String loincSystemUrl = "http://loinc.org";
	public static final String snomedSystemUrl = "http://snomed.info/sct";
	public static final String mdiCodesSystemURL = "http://hl7.org/fhir/us/mdi/CodeSystem/CodeSystem-vr-codes";
	public static final String mdiLocalComponentCodesURL = "http://hl7.org/fhir/us/mdi/CodeSystem/CodeSystem-local-component-codes";
	public static final String vrdrLocalComponentCodeSystem = "http://hl7.org/fhir/us/vrdr/CodeSystem/vrdr-component-cs";
	public static final CodeableConcept yesCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "Y", "Yes"));
	public static final CodeableConcept noCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0136", "N", "No"));
	public static final CodeableConcept askedButUnknownCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "ASKU", "asked but unknown"));
	public static final CodeableConcept notAskedCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "NASK", "not asked"));
	public static final CodeableConcept notApplicableCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "NA", "not applicable"));
	public static final CodeableConcept otherCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "OTH", "Other"));
	public static final CodeableConcept unknownCode = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-NullFlavor", "UNK", "Unknown"));
	public static final HashSet<CodeableConcept> yesNoUnknownNASKSet = new HashSet<>(Arrays.asList(
			yesCode,
			noCode,
			askedButUnknownCode,
			notAskedCode));
	public static final HashSet<CodeableConcept> yesNoNASet = new HashSet<>(Arrays.asList(
			yesCode,
			noCode,
			notApplicableCode));
	public static final HashSet<CodeType> dataAbsentReasonCodeSet = new HashSet<>(Arrays.asList(
			new CodeType("unknown"),
			new CodeType("asked-unknown"),
			new CodeType("not-asked"),
			new CodeType("asked-declined"),
			new CodeType("masked"),
			new CodeType("not-applicable"),
			new CodeType("unsupported"),
			new CodeType("as-text"),
			new CodeType("error"),
			new CodeType("not-a-number"),
			new CodeType("negative-infinity"),
			new CodeType("positive-infinity"),
			new CodeType("not-performed"),
			new CodeType("not-permitted")));
	public static final String partialDatePartAbsentReasonURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-Partial-date-part-absent-reason";
	public static final String partialDateDateYearURL = "date-year";
	public static final String partialDateDateYearAbsentReasonURL = "year-absent-reason";
	public static final String partialDateDateMonthURL = "date-month";
	public static final String partialDateDateMonthAbsentReasonURL = "month-absent-reason";
	public static final String partialDateDateDayURL = "date-day";
	public static final String partialDateDateDayAbsentReasonURL = "day-absent-reason";

	public static CodeableConcept findConceptFromCollectionUsingSimpleString(String key,
			Collection<CodeableConcept> collection) {
		for (CodeableConcept conceptIter : collection) {
			Coding coding = conceptIter.getCodingFirstRep();
			if (coding.getCode().equalsIgnoreCase(key) || coding.getDisplay().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}

	public static CodeType findCodeFromCollectionUsingSimpleString(String key, Collection<CodeType> collection) {
		for (CodeType conceptIter : collection) {
			if (conceptIter.getValue().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}

	public static Extension getExtension(DomainResource resource, String url) {
		for (Extension extension : resource.getExtension()) {
			if (extension.getUrl().equals(url)) {
				return extension;
			}
		}
		return null;
	}
	
	public static void setUUID(Resource resource) {
		resource.setId(new IdType(UUID.randomUUID().toString()));
	}
}
