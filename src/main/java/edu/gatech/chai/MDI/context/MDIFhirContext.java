package edu.gatech.chai.MDI.context;

import ca.uhn.fhir.context.FhirContext;

public class MDIFhirContext {
	FhirContext ctx;

	public MDIFhirContext() {
		ctx = FhirContext.forR4();
	}

	public FhirContext getCtx() {
		return ctx;
	}

	public void setCtx(FhirContext ctx) {
		this.ctx = ctx;
	}

}
