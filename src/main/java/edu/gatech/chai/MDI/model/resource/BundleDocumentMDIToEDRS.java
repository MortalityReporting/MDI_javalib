package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Bundle-document-mdi-to-edrs")
public class BundleDocumentMDIToEDRS extends Bundle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7622309533132493325L;

	public BundleDocumentMDIToEDRS() {
		super();
		this.setType(BundleType.DOCUMENT);
		BundleEntryComponent bec = new BundleEntryComponent();
		CompositionMDIToEDRS compositionEntry = new CompositionMDIToEDRS();
		bec.setResource(compositionEntry);
		this.addEntry(bec);
	}
	public BundleDocumentMDIToEDRS(Identifier identifier,CompositionMDIToEDRS compositionEntry) {
		super();
		this.setIdentifier(identifier);
		this.setType(BundleType.DOCUMENT);
		BundleEntryComponent bec = new BundleEntryComponent();
		bec.setResource(compositionEntry);
		this.addEntry(bec);
	}
	
	//This Composition must always be the correct case here.
	public CompositionMDIToEDRS getCompositionMDIToEDRS() {
		return (CompositionMDIToEDRS) this.getEntryFirstRep().getResource();
	}
}