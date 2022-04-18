package edu.gatech.chai.MDI.context;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.chai.MDI.model.resource.BundleDocumentMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.CompositionMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.ObservationCauseOfDeathCondition;
import edu.gatech.chai.MDI.model.resource.ObservationConditionContributingToDeath;
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

public class MDIFhirContext {
	FhirContext ctx;
	public MDIFhirContext() {
		ctx = FhirContext.forR4();
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Bundle-document-mdi-to-edrs",
				BundleDocumentMDIToEDRS.class);
		ctx.setDefaultTypeForProfile("https://fhir.org/fhir/us/mdi/StructureDefinition/Composition-mdi-to-edrs",
				CompositionMDIToEDRS.class);
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
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-cause-of-death-condition",
				ObservationCauseOfDeathCondition.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-condition-contributing-to-death",
				ObservationConditionContributingToDeath.class);
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