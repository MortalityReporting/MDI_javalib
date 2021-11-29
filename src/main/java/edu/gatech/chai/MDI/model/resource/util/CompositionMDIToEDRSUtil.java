package edu.gatech.chai.MDI.model.resource.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.VRDR.model.util.CommonUtil;


public class CompositionMDIToEDRSUtil {
	public static final CodeableConcept type = new CodeableConcept().setText("MDI To EDRS");
	public static final CodeableConcept demographicsSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.loincSystemUrl,"57073-9","Prenatal records"));
}
