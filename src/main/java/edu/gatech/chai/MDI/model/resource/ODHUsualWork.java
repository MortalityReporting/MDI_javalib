package edu.gatech.chai.MDI.model.resource;

import java.math.BigDecimal;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ODHUsualWorkUtil;
import edu.gatech.chai.VRDR.model.util.DecedentUsualWorkUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/odh/StructureDefinition/odh-UsualWork")
public class ODHUsualWork extends Observation{
	public ODHUsualWork() {
		addCategory(ODHUsualWorkUtil.category);
		setCode(ODHUsualWorkUtil.code);
	}
	
	public ODHUsualWork(CodeableConcept usualWork, CodeableConcept usualIndustryValue, Integer occupationYears) {
		this();
		setValue(usualWork);
		addUsualIndustry(usualIndustryValue);
		addOccupationDuration(occupationYears);
	}
	
	
	public void addUsualIndustry(CodeableConcept usualIndustryValue) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(ODHUsualWorkUtil.usualIndustryComponentCode);
		component.setValue(usualIndustryValue);
		addComponent(component);
	}
	
	public void addOccupationDuration(Integer years) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(ODHUsualWorkUtil.occupationDurationComponentCode);
		Quantity yearsQuantity = new Quantity();
		yearsQuantity.setCode("a");
		yearsQuantity.setSystem("http://unitsofmeasure.org");
		yearsQuantity.setValue(new BigDecimal(years));
		component.setValue(yearsQuantity);
		addComponent(component);
	}
}