package edu.gatech.MDI;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition.SectionComponent;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.ListResource.ListEntryComponent;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.MessageHeader;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.UriType;

import edu.gatech.chai.MDI.model.resource.BundleDocumentMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.CompositionMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.ListCauseOfDeathPathway;
import edu.gatech.chai.MDI.model.resource.ODHUsualWork;
import edu.gatech.chai.MDI.model.resource.ObservationCauseOfDeathCondition;
import edu.gatech.chai.MDI.model.resource.ObservationConditionContributingToDeath;
import edu.gatech.chai.MDI.model.resource.ObservationDeathDate;
import edu.gatech.chai.MDI.model.resource.ObservationDeathInjuryAtWork;
import edu.gatech.chai.MDI.model.resource.ObservationDecedentPregnancy;
import edu.gatech.chai.MDI.model.resource.ObservationMannerOfDeath;
import edu.gatech.chai.MDI.model.resource.ObservationTobaccoUseContributedToDeath;
import edu.gatech.chai.VRDR.model.TobaccoUseContributedToDeath;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

public class BuildMDIToEdrsDocument {
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	public static BundleDocumentMDIToEDRS buildExampleBundleDocumentMDIToEDRS() {
		List<Resource> contents = new ArrayList<Resource>();
		//DeathCertificate is the main fhir resource that contains sectional references to everything else
    	CompositionMDIToEDRS mainComposition = new CompositionMDIToEDRS();
    	initResourceForTesting(mainComposition);
    	contents.add(mainComposition);
    	//MDIToEDRSDocument contains the top-level item that represents the entire bundle
    	BundleDocumentMDIToEDRS bundleDocument = new BundleDocumentMDIToEDRS();
    	bundleDocument.setIdentifier(new Identifier().setValue("123").setSystem("urn:test"));
    	initResourceForTesting(bundleDocument);
    	//Patient
    	Patient decedent = new Patient();
    	initResourceForTesting(decedent);
    	
    	decedent.getMeta().addProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient");
    	//Setting USCore specific race, ethnicity, birthsex
    	Extension raceExtension = new Extension("http://hl7.org/fhir/us/core/StructureDefinition/us-core-race");
    	raceExtension.addExtension("ombCategory", new Coding("urn:oid:2.16.840.1.113883.6.238","2028-9","Asian"));
    	raceExtension.addExtension("detailed", new Coding("urn:oid:2.16.840.1.113883.6.238","2034-7","Chinese"));
    	raceExtension.addExtension("text", new StringType("Chinese"));
    	Extension ethnicityExtension = new Extension("http://hl7.org/fhir/us/core/StructureDefinition/us-core-race");
    	ethnicityExtension.addExtension("ombCategory", new Coding("urn:oid:2.16.840.1.113883.6.238","2186-5","Non Hispanic or Latino"));
    	ethnicityExtension.addExtension("text", new StringType("Not Hispanic Or Latino"));
    	Extension birthSexExtension = new Extension("http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex");
    	birthSexExtension.setValue(new CodeType("M"));
    	
    	decedent.addExtension(raceExtension);
    	decedent.addExtension(ethnicityExtension);
    	decedent.addExtension(birthSexExtension);
    	
    	Address decedentsHome = new Address().addLine("1808 Stroop Hill Road").setCity("Atlanta")
		.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.HOME);
    	decedent.setGender(AdministrativeGender.MALE);
    	decedent.addIdentifier(new Identifier().setSystem("http://hl7.org/fhir/sid/us-ssn").setValue("123-45-6789"));
    	decedent.addName(new HumanName().setFamily("Edgarson").addGiven("Edger").setUse(NameUse.OFFICIAL));
    	Reference decedentReference = new Reference("Patient/"+decedent.getId());
    	contents.add(decedent);
    	//Practitioner
    	//Note: The Practitioner used in MDI is a USCore Practitioner
    	Practitioner examiner = new Practitioner();
    	initResourceForTesting(examiner);
    	examiner.getMeta().addProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-practitioner");
    	examiner.addIdentifier(new Identifier().setSystem("http://hl7.org/fhir/sid/us-npi").setValue("1234567893"));
    	examiner.addName(new HumanName().setFamily("Pratt").addGiven("Practitioner").setUse(NameUse.OFFICIAL));
    	Reference examinerReference = new Reference("Practitioner/"+examiner.getId());
    	contents.add(examiner);
    	
    	mainComposition.setSubject(decedentReference);
    	mainComposition.addAuthor(examinerReference);
    	//Every subsequent resource must be added to a contents section
    	//Demographics Section
    	SectionComponent demographicsSection = mainComposition.getDemographicsSection();
    	//  Odh Usual Work
    	try {
    		ODHUsualWork usualWork = new ODHUsualWork();
        	initResourceForTesting(usualWork);
        	usualWork.setValue(new CodeableConcept().addCoding(new Coding("2.16.840.1.114222.4.5.314","7140","Aircraft mechanics and service technicians")));
        	usualWork.addUsualIndustry(new CodeableConcept().addCoding(new Coding("https://terminology.hl7.org/2.0.0/CodeSystem-PHIndustryCDCCensus2010","8270","Nursing care facilities")));
        	usualWork.addOccupationDuration(10);
        	usualWork.setSubject(decedentReference);
			usualWork.setEffective(new Period().setStart(formatter.parse("02-10-2010")).setEnd(formatter.parse("03-10-2022")));
			demographicsSection.addEntry(new Reference(usualWork));
	    	contents.add(usualWork);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	//Circumstances Section
    	SectionComponent circumstancesSection = mainComposition.getCircumstancesSection();
    	//  Death Location
    	Location deathLocation = new Location();
    	initResourceForTesting(deathLocation);
    	deathLocation.getMeta().addProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-location");
    	deathLocation.setName("Eagle Street Pub");
    	deathLocation.setAddress(new Address().addLine("4666 Eagle Street").setCity("Stlouis").setState("IL").setPostalCode("63101"));
    	circumstancesSection.addEntry(new Reference(deathLocation));
    	contents.add(deathLocation);
    	// Work Injury
    	ObservationDeathInjuryAtWork deathInjuryAtWork = new ObservationDeathInjuryAtWork(decedent, "Yes");
    	initResourceForTesting(deathInjuryAtWork);
    	circumstancesSection.addEntry(new Reference(deathInjuryAtWork));
    	contents.add(deathInjuryAtWork);
    	// TobaccoUseContributedToDeath
    	ObservationTobaccoUseContributedToDeath tobacco = new ObservationTobaccoUseContributedToDeath(decedent, "No");
    	initResourceForTesting(tobacco);
    	circumstancesSection.addEntry(new Reference(tobacco));
    	contents.add(tobacco);
    	// DecedentPregnancy
    	ObservationDecedentPregnancy pregnancy = new ObservationDecedentPregnancy(decedent, "Not pregnant within past year");
    	initResourceForTesting(pregnancy);
    	circumstancesSection.addEntry(new Reference(pregnancy));
    	contents.add(pregnancy);
    	//Jurisdiction Section
    	SectionComponent jurisdictionSection = mainComposition.getJurisdictionSection();
    	// DeathDate
    	ObservationDeathDate deathDate;
		try {
			deathDate = new ObservationDeathDate(decedent, formatter.parse("03-10-2022"),formatter.parse("03-12-2022"));
			initResourceForTesting(deathDate);
	    	jurisdictionSection.addEntry(new Reference(deathDate));
	    	contents.add(deathDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//CauseManner Section
    	SectionComponent causeMannerSection = mainComposition.getCauseMannerSection();
    	//  CauseOfDeathPathway
    	ListCauseOfDeathPathway pathway = new ListCauseOfDeathPathway(decedent, examiner);
    	initResourceForTesting(pathway);
    	causeMannerSection.addEntry(new Reference(pathway));
    	contents.add(pathway);
    	//    CauseOfDeathCondition
    	ObservationCauseOfDeathCondition causeOfDeath = new ObservationCauseOfDeathCondition(decedent, examiner);
    	initResourceForTesting(causeOfDeath);
    	causeOfDeath.setValue(new StringType("Heart Disease"));
    	causeOfDeath.setInterval(0, "min");
    	pathway.addEntry(new ListEntryComponent().setItem(new Reference(causeOfDeath)));
    	contents.add(causeOfDeath);
    	//  ConditionContributingToDeath
    	ObservationConditionContributingToDeath conditionContrib = new ObservationConditionContributingToDeath(decedent, examiner, "Diabetes");
    	initResourceForTesting(conditionContrib);
    	causeMannerSection.addEntry(new Reference(conditionContrib));
    	contents.add(conditionContrib);
    	//    MannerOfDeath
    	ObservationMannerOfDeath manner = new ObservationMannerOfDeath("Natural", decedent, examiner);
    	initResourceForTesting(manner);
    	causeMannerSection.addEntry(new Reference(manner));
    	contents.add(manner);
    	//MedicationHistory  Section
    	SectionComponent medicalHistorySection = mainComposition.getMedicalHistorySection();
    	//historicalCondition
    	Condition historicalCondition = new Condition();
    	initResourceForTesting(historicalCondition);
    	historicalCondition.getMeta().addProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition");
    	historicalCondition.setClinicalStatus(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/condition-clinical","active","Active")));
    	historicalCondition.setVerificationStatus(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/condition-ver-status","confirmed","Confirmed")));
    	historicalCondition.addCategory(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/condition-category","health-concern","Health Concern")));
    	historicalCondition.setCode(new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"168000","Typhlolithiasis")));
    	historicalCondition.setSubject(decedentReference);
    	medicalHistorySection.addEntry(new Reference(historicalCondition));
    	contents.add(historicalCondition);
    	
    	for(Resource resource:contents) {
    		bundleDocument.addEntry().setResource(resource).setFullUrl(resource.getResourceType()+"/"+resource.getId());
    	}
    	return bundleDocument;
	}
	
	private static void initResourceForTesting(Resource resource) {
		CommonUtil.setUUID(resource);
	}
}
