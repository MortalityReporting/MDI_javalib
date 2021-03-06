package edu.gatech.chai.MDI.model.resource;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.CompositionMDIToEDRSUtil;
import edu.gatech.chai.MDI.model.resource.util.MDICommonUtil;

@ResourceDef(name = "Composition", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Composition-mdi-to-edrs")
public class CompositionMDIToEDRS extends Composition{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5634970999252166773L;

	public CompositionMDIToEDRS() {
		super();
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Practitioner author) {
		super();
		Reference authorRef = new Reference(author);
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,PractitionerRole author) {
		super();
		Reference authorRef = new Reference(author);
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Device author) {
		super();
		Reference authorRef = new Reference(author);
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Patient author) {
		super();
		Reference authorRef = new Reference(author);
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,RelatedPerson author) {
		super();
		Reference authorRef = new Reference(author);
		commonInit(identifier,status,date,subject,authorRef);
	}
	
	public CompositionMDIToEDRS(Identifier identifier, CompositionStatus status, Date date, Patient subject,Organization author) {
		super();
		Reference authorRef = new Reference(author);
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
		Reference subjectRef = new Reference(subject);
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
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.demographicsSectionCode);
		if(returnValue == null) {
			returnValue = createDemographicsSection();
		}
		return returnValue;
	}
	
	public SectionComponent getCircumstancesSection() {
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.circumstancesSectionCode);
		if(returnValue == null) {
			returnValue = createCircumstancesSection();
		}
		return returnValue;
	}
	
	public SectionComponent getJurisdictionSection() {
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.jurisdictionSectionCode);
		if(returnValue == null) {
			returnValue = createJurisdictionSection();
		}
		return returnValue;
	}
	
	public SectionComponent getCauseMannerSection() {
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.causeMannerSectionCode);
		if(returnValue == null) {
			returnValue = createCauseMannerSection();
		}
		return returnValue;
	}
	
	public SectionComponent getMedicalHistorySection() {
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.medicalHistorySectionCode);
		if(returnValue == null) {
			returnValue = createMedicalHistorySection();
		}
		return returnValue;
	}
	
	public SectionComponent getExamAutopsySection() {
		SectionComponent returnValue = getSection(CompositionMDIToEDRSUtil.examAutopsySectionCode);
		if(returnValue == null) {
			returnValue = createExamAutopsySection();
		}
		return returnValue;
	}
	
	public SectionComponent getNarrativeSection() {
		return getSection(CompositionMDIToEDRSUtil.narrativeSectionCode);
	}
	
	protected SectionComponent getSection(CodeableConcept codeableConcept) {
		if(this.section == null) {
			return null;
		}
		for(SectionComponent secComp:this.section) {
			if(secComp.getCode().equals(codeableConcept)) {
				return secComp;
			}
		}
		return null;
	}
	
	public Extension addMDICaseIdExtension(String mdiCaseValue) {
		Extension returnExtension = new Extension();
		returnExtension.setUrl(CompositionMDIToEDRSUtil.trackingNumberExtensionURL);
		Identifier identifier = new Identifier();
		identifier.setType(CompositionMDIToEDRSUtil.trackingNumberMDIType);
		identifier.setValue(mdiCaseValue);
		returnExtension.setValue(identifier);
		this.addExtension(returnExtension);
		return returnExtension;
	}
	
	public Extension addEDRSCaseIdExtension(String edrsCaseValue) {
		Extension returnExtension = new Extension();
		returnExtension.setUrl(CompositionMDIToEDRSUtil.trackingNumberExtensionURL);
		Identifier identifier = new Identifier();
		identifier.setType(CompositionMDIToEDRSUtil.trackingNumberEDRSType);
		identifier.setValue(edrsCaseValue);
		returnExtension.setValue(identifier);
		this.addExtension(returnExtension);
		return returnExtension;
	}
	
	public Extension addTOXCaseIdExtension(String toxCaseValue) {
		Extension returnExtension = new Extension();
		returnExtension.setUrl(CompositionMDIToEDRSUtil.trackingNumberExtensionURL);
		Identifier identifier = new Identifier();
		identifier.setType(CompositionMDIToEDRSUtil.trackingNumberTOXType);
		identifier.setValue(toxCaseValue);
		returnExtension.setValue(identifier);
		this.addExtension(returnExtension);
		return returnExtension;
	}
}