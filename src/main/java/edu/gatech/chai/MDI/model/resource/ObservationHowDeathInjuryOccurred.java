package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationDeathInjuryAtWorkUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationDecedentPregnancyUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationHowDeathInjuryOccurredUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;
import edu.gatech.chai.VRDR.model.util.InjuryIncidentUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-how-death-injury-occurred")
public class ObservationHowDeathInjuryOccurred extends Observation {

	public ObservationHowDeathInjuryOccurred() {
		super();
		setCode(ObservationHowDeathInjuryOccurredUtil.code);
	}

	public ObservationHowDeathInjuryOccurred(Patient subject, String value) {
		this();
		Reference ref = new Reference(subject);
		setSubject(ref);
		setValue(new StringType(value));
	}
	
	public ObservationHowDeathInjuryOccurred(Patient subject, Practitioner performer, String value) {
		this();
		Reference ref = new Reference(subject);
		setSubject(ref);
		ref = new Reference(subject);
		addPerformer(ref);
		setValue(new StringType(value));
	}
	
}