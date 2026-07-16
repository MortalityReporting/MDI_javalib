package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.DocumentReferenceMDIReportUtil;

@ResourceDef(name = "DocumentReference", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/DocumentReference-mdi-report")
public class DocumentReferenceMDIReport extends DocumentReference{
	public DocumentReferenceMDIReport() {
		super();
	}

	public DocumentReferenceMDIReport(Patient subject) {
		this.setType(DocumentReferenceMDIReportUtil.type);
		this.addCategory(DocumentReferenceMDIReportUtil.category);
	}
	
	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient);
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
}