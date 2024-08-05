package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationConditionCauseOfDeathUtil;
import edu.gatech.chai.VRCL.model.PractitionerVitalRecords;
import edu.gatech.chai.model.Certifier;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-mdi-cause-of-death-part1")
public class ObservationCauseOfDeathPart1 extends Observation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObservationCauseOfDeathPart1() {
		super();
		this.setCode(ObservationConditionCauseOfDeathUtil.code);
	}
	
	public ObservationCauseOfDeathPart1(Patient patient, PractitionerVitalRecords practitioner, String value, int lineNumber, String interval) {
		this();
		setPatient(patient);
		addPerformer(practitioner);
		setValue(new CodeableConcept().setText(value));
		setLineNumber(lineNumber);
		setInterval(interval);
	}

	public ObservationCauseOfDeathPart1(Patient patient, Certifier practitioner, String value, int lineNumber, String interval) {
		this();
		setPatient(patient);
		addPerformer(practitioner);
		setValue(new CodeableConcept().setText(value));
		setLineNumber(lineNumber);
		setInterval(interval);
	}
	
	public void addPerformer(Practitioner practitioner) {
		Reference reference = new Reference(practitioner);
		addPerformer(reference);
	}

	public void setPatient(Patient patient) {
		Reference reference = new Reference(patient);
		this.subject = reference;
	}
	
	public void setSubject(Patient patient) {
		setPatient(patient);
	}
	
	public Reference getPatient() {
		return subject;
	}

	public ObservationComponentComponent setLineNumber(int lineNumber) {
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(ObservationConditionCauseOfDeathUtil.lineNumberComponentCode);
		occ.setValue(new IntegerType(lineNumber));
		this.addComponent(occ);
		return occ;
	}

	public Integer getLineNumber() {
		for(ObservationComponentComponent occ:this.getComponent()){
			if(occ.getCode().equals(ObservationConditionCauseOfDeathUtil.lineNumberComponentCode)){
				return ((IntegerType)occ.getValue()).getValue();
			}
		}
		return null;
	}
	
	public ObservationComponentComponent setInterval(String value) {
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(ObservationConditionCauseOfDeathUtil.intervalComponentCode);
		occ.setValue(new StringType(value));
		this.addComponent(occ);
		return occ;
	}

	public String getInterval() {
		for(ObservationComponentComponent occ:this.getComponent()){
			if(occ.getCode().equals(ObservationConditionCauseOfDeathUtil.lineNumberComponentCode)){
				return ((StringType)occ.getValue()).getValue();
			}
		}
		return null;
	}
}