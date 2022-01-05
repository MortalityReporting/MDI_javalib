package edu.gatech.chai.MDI.model.resource;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.CompositionMDIToEDRSUtil;

@ResourceDef(name = "Composition", profile = "https://fhir.org/fhir/us/mdi/StructureDefinition/Composition-mdi-to-edrs")
public class CompositionMDIToEDRS extends Composition{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5634970999252166773L;

	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Practitioner author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,PractitionerRole author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Device author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Patient author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,RelatedPerson author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Organization author) {
		super();
		Reference authorRef = new Reference(author.getId());
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	
	public void commonInit(Identifier identifier, CompositionStatus status, Date date, Patient subject,Reference authorRef) {
		this.setIdentifier(identifier);
		this.setStatus(status);
		this.setType(CompositionMDIToEDRSUtil.type);
		if(date == null) {
			date = new Date();
		}
		this.setDate(date);
		Reference subjectRef = new Reference(subject.getId());
		this.setSubject(subjectRef);
		this.addAuthor(authorRef);
	}
	
	public SectionComponent createDemographicsSection() {
		return createSection(CompositionMDIToEDRSUtil.demographicsSectionCode);
	}
	
	public SectionComponent createCircumstancesSection() {
		return createSection(CompositionMDIToEDRSUtil.circumstancesSectionCode);
	}
	
	public SectionComponent createJurisdictionSection() {
		return createSection(CompositionMDIToEDRSUtil.jurisdictionSectionCode);
	}
	
	public SectionComponent createCauseMannerSection() {
		return createSection(CompositionMDIToEDRSUtil.causeMannerSectionCode);
	}
	
	public SectionComponent createMedicalHistorySection() {
		return createSection(CompositionMDIToEDRSUtil.medicalHistorySectionCode);
	}
	
	public SectionComponent createExamAutopsySection() {
		return createSection(CompositionMDIToEDRSUtil.examAutopsySectionCode);
	}
	
	public SectionComponent createNarrativeSection() {
		return createSection(CompositionMDIToEDRSUtil.narrativeSectionCode);
	}
	
	protected SectionComponent createSection(CodeableConcept codeableConcept) {
		SectionComponent secComp = new SectionComponent();
		secComp.setCode(codeableConcept);
		this.addSection(secComp);
		return secComp;
	}
	
	public SectionComponent getDemographicsSection() {
		return getSection(CompositionMDIToEDRSUtil.demographicsSectionCode);
	}
	
	public SectionComponent getCircumstancesSection() {
		return getSection(CompositionMDIToEDRSUtil.circumstancesSectionCode);
	}
	
	public SectionComponent getJurisdictionSection() {
		return getSection(CompositionMDIToEDRSUtil.jurisdictionSectionCode);
	}
	
	public SectionComponent getCauseMannerSection() {
		return getSection(CompositionMDIToEDRSUtil.causeMannerSectionCode);
	}
	
	public SectionComponent getMedicalHistorySection() {
		return getSection(CompositionMDIToEDRSUtil.medicalHistorySectionCode);
	}
	
	public SectionComponent getExamAutopsySection() {
		return getSection(CompositionMDIToEDRSUtil.examAutopsySectionCode);
	}
	
	public SectionComponent getNarrativeSection() {
		return getSection(CompositionMDIToEDRSUtil.narrativeSectionCode);
	}
	
	protected SectionComponent getSection(CodeableConcept codeableConcept) {
		for(SectionComponent secComp:this.section) {
			if(secComp.getCode().equals(codeableConcept)) {
				return secComp;
			}
		}
		return null;
	}
	
}