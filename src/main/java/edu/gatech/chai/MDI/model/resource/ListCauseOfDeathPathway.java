package edu.gatech.chai.MDI.model.resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathPathwayUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

import org.hl7.fhir.r4.model.ListResource;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;

@ResourceDef(name = "List", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/List-cause-of-death-pathway")
public class ListCauseOfDeathPathway extends ListResource{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7385398617988694866L;

	public ListCauseOfDeathPathway() {
		super();
		CommonUtil.initResource(this);
		setStatus(CauseOfDeathPathwayUtil.status);
		setMode(CauseOfDeathPathwayUtil.mode);
	}
	
	public ListCauseOfDeathPathway(Patient subject, Practitioner source) {
		super();
		CommonUtil.initResource(this);
		setStatus(CauseOfDeathPathwayUtil.status);
		setMode(CauseOfDeathPathwayUtil.mode);
		setPatient(subject);
		setSource(source);
	}
	
	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient);
		this.subject = reference;
	}
	
	public Reference getPatient() {
		return subject;
	}
	
	public void setSource(Practitioner practitioner) {
		Reference reference = new Reference(practitioner);
		this.source = reference;
	}
	
	public Reference getSource() {
		return source;
	}
	
}
