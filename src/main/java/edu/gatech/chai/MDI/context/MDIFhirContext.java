package edu.gatech.chai.MDI.context;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.chai.MDI.model.resource.BundleDocumentMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.CompositionMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.ConditionCauseOfDeath;
import edu.gatech.chai.MDI.model.resource.ConditionOtherContributingToDeath;
import edu.gatech.chai.MDI.model.resource.DiagnosticReportToxicologyToMDI;
import edu.gatech.chai.MDI.model.resource.DocumentReferenceMDICaseHistory;
import edu.gatech.chai.MDI.model.resource.DocumentReferenceMDICaseNotesSummary;
import edu.gatech.chai.MDI.model.resource.ListCauseOfDeathPathway;
import edu.gatech.chai.MDI.model.resource.MessageHeaderToxicologyToMDI;
import edu.gatech.chai.MDI.model.resource.ODHUsualWork;
import edu.gatech.chai.MDI.model.resource.ObservationDeathDate;
import edu.gatech.chai.MDI.model.resource.ObservationDeathInjuryAtWork;
import edu.gatech.chai.MDI.model.resource.ObservationDecedentPregnancy;
import edu.gatech.chai.MDI.model.resource.ObservationHowDeathInjuryOccurred;
import edu.gatech.chai.MDI.model.resource.ObservationMannerOfDeath;
import edu.gatech.chai.MDI.model.resource.ObservationTobaccoUseContributedToDeath;
import edu.gatech.chai.MDI.model.resource.SpecimenToxicologyLab;
import edu.gatech.chai.MDI.model.resource.USCoreObservationLab;
import edu.gatech.chai.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.chai.VRDR.model.BirthRecordIdentifier;
import edu.gatech.chai.VRDR.model.CauseOfDeathCondition;
import edu.gatech.chai.VRDR.model.CauseOfDeathPathway;
import edu.gatech.chai.VRDR.model.Certifier;
import edu.gatech.chai.VRDR.model.ConditionContributingToDeath;
import edu.gatech.chai.VRDR.model.DeathCertificate;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;
import edu.gatech.chai.VRDR.model.DeathCertificateReference;
import edu.gatech.chai.VRDR.model.DeathCertification;
import edu.gatech.chai.VRDR.model.DeathDate;
import edu.gatech.chai.VRDR.model.DeathLocation;
import edu.gatech.chai.VRDR.model.DeathPronouncementPerformer;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.DecedentAge;
import edu.gatech.chai.VRDR.model.DecedentDispositionMethod;
import edu.gatech.chai.VRDR.model.DecedentEducationLevel;
import edu.gatech.chai.VRDR.model.DecedentFather;
import edu.gatech.chai.VRDR.model.DecedentMother;
import edu.gatech.chai.VRDR.model.DecedentPregnancy;
import edu.gatech.chai.VRDR.model.DecedentSpouse;
import edu.gatech.chai.VRDR.model.DecedentTransportationRole;
import edu.gatech.chai.VRDR.model.DecedentUsualWork;
import edu.gatech.chai.VRDR.model.DispositionLocation;
import edu.gatech.chai.VRDR.model.ExaminerContacted;
import edu.gatech.chai.VRDR.model.FuneralHome;
import edu.gatech.chai.VRDR.model.FuneralServiceLicensee;
import edu.gatech.chai.VRDR.model.InjuryIncident;
import edu.gatech.chai.VRDR.model.InjuryLocation;
import edu.gatech.chai.VRDR.model.InterestedParty;
import edu.gatech.chai.VRDR.model.MannerOfDeath;
import edu.gatech.chai.VRDR.model.Mortician;
import edu.gatech.chai.VRDR.model.TobaccoUseContributedToDeath;

public class MDIFhirContext {
	FhirContext ctx;
	public MDIFhirContext() {
		ctx = FhirContext.forR4();
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Bundle-document-mdi-to-edrs",
				BundleDocumentMDIToEDRS.class);
		ctx.setDefaultTypeForProfile("https://fhir.org/fhir/us/mdi/StructureDefinition/Composition-mdi-to-edrs",
				CompositionMDIToEDRS.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Condition-cause-of-death",
				ConditionCauseOfDeath.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Condition-other-contributing-to-death",
				ConditionOtherContributingToDeath.class);
		ctx.setDefaultTypeForProfile("https://fhir.org/fhir/us/mdi/StructureDefinition/DiagnosticReport-toxicology-to-mdi",
				DiagnosticReportToxicologyToMDI.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/DocumentReference-mdi-case-history",
				DocumentReferenceMDICaseHistory.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/DocumentReference-mdi-case-notes-summary",
				DocumentReferenceMDICaseNotesSummary.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/List-cause-of-death-pathway",
				ListCauseOfDeathPathway.class);
		ctx.setDefaultTypeForProfile("https://fhir.org/fhir/us/mdi/StructureDefinition/MessageHeader-toxicology-to-mdi",
				MessageHeaderToxicologyToMDI.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-death-date",
				ObservationDeathDate.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-death-injury-at-work",
				ObservationDeathInjuryAtWork.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-decedent-pregnancy",
				ObservationDecedentPregnancy.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-manner-of-death",
				ObservationMannerOfDeath.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-how-death-injury-occurred",
				ObservationHowDeathInjuryOccurred.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-tobacco-use-contributed-to-death",
				ObservationTobaccoUseContributedToDeath.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-tobacco-use-contributed-to-death",
				ODHUsualWork.class);
		ctx.setDefaultTypeForProfile("https://fhir.org/fhir/us/mdi/StructureDefinition/Specimen-toxicology-lab",
				SpecimenToxicologyLab.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-observation-lab",
				USCoreObservationLab.class);
	}

	public FhirContext getCtx() {
		return ctx;
	}

	public void setCtx(FhirContext ctx) {
		this.ctx = ctx;
	}

}