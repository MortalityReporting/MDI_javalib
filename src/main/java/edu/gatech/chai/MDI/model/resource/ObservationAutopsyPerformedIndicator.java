package edu.gatech.chai.MDI.model.resource;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Type;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ObservationAutopsyPerformedIndicatorUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationDeathDateUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-autopsy-performed-indicator")
public class ObservationAutopsyPerformedIndicator extends Observation {

	public ObservationAutopsyPerformedIndicator() {
		super();
		CommonUtil.initResource(this);
		setCode(ObservationAutopsyPerformedIndicatorUtil.code);
		setStatus(ObservationAutopsyPerformedIndicatorUtil.status);
	}

	public ObservationAutopsyPerformedIndicator(Reference subject, CodeableConcept autopsyPerformed, CodeableConcept resultsAvailable) {
		this();
		setSubject(subject);
		setValue(autopsyPerformed);
		addResultsAvailableComponent(resultsAvailable);
	}

	public ObservationAutopsyPerformedIndicator(Reference subject, String autopsyPerformed, String resultsAvailable) {
		this();
		setSubject(subject);
		CodeableConcept autopsyPerformedCC = CommonUtil.findConceptFromCollectionUsingSimpleString(autopsyPerformed, CommonUtil.yesNoUnknownSet);
		setValue(autopsyPerformedCC);
		CodeableConcept resultsAvailableCC = CommonUtil.findConceptFromCollectionUsingSimpleString(resultsAvailable, CommonUtil.yesNoUnknownSet);
		addResultsAvailableComponent(resultsAvailableCC);
	}
	
	public ObservationComponentComponent addResultsAvailableComponent(CodeableConcept resultsAvailable){
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(ObservationAutopsyPerformedIndicatorUtil.resultsAvailableComponentCode);
		occ.setValue(resultsAvailable);
		this.addComponent(occ);
		return occ;
	}
}
