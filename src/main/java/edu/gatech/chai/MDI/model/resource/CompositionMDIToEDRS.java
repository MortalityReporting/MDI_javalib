package edu.gatech.chai.MDI.model.resource;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.CompositionMDIToEDRSUtil;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.DecedentAge;

@ResourceDef(name = "Composition", profile = "https://fhir.org/fhir/us/mdi/StructureDefinition/Composition-mdi-to-edrs")
public class CompositionMDIToEDRS extends Composition{
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,Practitioner author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,PractitionerRole author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,Device author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,Patient author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,RelatedPerson author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	public CompositionMDIToEDRS(String title, CompositionStatus status, Date date, Decedent decedent,Organization author) {
		Reference authorRef = new Reference(author);
		commonInit(title,status,date,decedent,authorRef);
	}
	
	
	public void commonInit(String title, CompositionStatus status, Date date, Decedent decedent,Reference authorRef) {
		this.setTitle(title);
		this.setStatus(status);
		this.setType(CompositionMDIToEDRSUtil.type);
		if(date == null) {
			date = new Date();
		}
		this.setDate(date);
		Reference decedentRef = new Reference(decedent);
		this.setSubject(decedentRef);
		this.addAuthor(authorRef);
		this.createDemographicsSection();
		this.createCircumstancesSection();
		this.createJurisdictionSection();
		this.createCauseMannerSection();
		this.createLocationsSection();
		this.createDateTimeSection();
		this.createMedicalHistorySection();
		this.createExamAutopsySection();
	}
	
	public SectionComponent createDemographicsSection() {
		SectionComponent secComp = new SectionComponent();
		secComp.setCode(CompositionMDIToEDRSUtil.demographicsSectionCode);
		this.addSection(secComp);
		return secComp;
	}
	
	public SectionComponent createCircumstancesSection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createJurisdictionSection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createCauseMannerSection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createLocationsSection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createDateTimeSection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createMedicalHistorySection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent createExamAutopsySection() {
		SectionComponent secComp = new SectionComponent();
		return secComp;
	}
	
	public SectionComponent getDemographicsSection() {
		for(SectionComponent secComp:this.section) {
			if(secComp.getCode().equals(CompositionMDIToEDRSUtil.demographicsSectionCode)) {
				return secComp;
			}
		}
		return null;
	}
	
	public SectionComponent addDecedentAge(DecedentAge decedentAge) {
		SectionComponent secComp = getDemographicsSection();
		if(secComp == null) {
			secComp = createDemographicsSection();
		}
		Reference decedentAgeRef = new Reference(decedentAge);
		secComp.addEntry(decedentAgeRef);
		return secComp;
	}
}
