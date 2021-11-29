package edu.gatech.chai.MDI.model.resource;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.DiagnosticReportToxicologyToMDIUtil;
import edu.gatech.chai.VRDR.model.Decedent;

@ResourceDef(name = "DiagnosticReport", profile = "https://fhir.org/fhir/us/mdi/StructureDefinition/DiagnosticReport-toxicology-to-mdi")
public class DiagnosticReportToxicologyToMDI extends DiagnosticReport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4006245721303024706L;
	
	public DiagnosticReportToxicologyToMDI(DiagnosticReportStatus status, Decedent decedent, CodeableConcept code, Date effective, Date issued) {
		this.setStatus(status);
		this.setCode(code);
		this.setSubject(new Reference(decedent));
		this.setEffective(new DateTimeType(effective));
		this.setIssued(issued);
		this.addCategory(DiagnosticReportToxicologyToMDIUtil.category);
	}
}