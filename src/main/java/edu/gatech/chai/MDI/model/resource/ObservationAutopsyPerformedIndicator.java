package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.CommonUtil;
import edu.gatech.chai.MDI.model.resource.util.ObservationAutopsyPerformedIndicatorUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Observation-autopsy-performed-indicator")
public class ObservationAutopsyPerformedIndicator extends Observation {

	public ObservationAutopsyPerformedIndicator() {
		super();
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
		CodeableConcept autopsyPerformedCC = CommonUtil.findConceptFromCollectionUsingSimpleString(autopsyPerformed, CommonUtil.yesNoUnknownNASKSet);
		setValue(autopsyPerformedCC);
		CodeableConcept resultsAvailableCC = CommonUtil.findConceptFromCollectionUsingSimpleString(resultsAvailable, CommonUtil.yesNoUnknownNASKSet);
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
