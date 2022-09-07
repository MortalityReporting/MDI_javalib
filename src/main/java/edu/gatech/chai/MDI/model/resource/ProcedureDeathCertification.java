package edu.gatech.chai.MDI.model.resource;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.MDI.model.resource.util.ProcedureDeathCertificationUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Procedure", profile = "http://hl7.org/fhir/us/mdi/StructureDefinition/Procedure-death-certification")
public class ProcedureDeathCertification extends Procedure{
    public ProcedureDeathCertification(){
        super();
        setCategory(ProcedureDeathCertificationUtil.category);
        setCode(ProcedureDeathCertificationUtil.code);
    }

    public ProcedureDeathCertification(Reference performer, String certifierType){
        super();
        setCategory(ProcedureDeathCertificationUtil.category);
        setCode(ProcedureDeathCertificationUtil.code);
        this.addPerformer(performer, certifierType);
    }

    public ProcedurePerformerComponent addPerformer(Reference performer, String certifierType){
        ProcedurePerformerComponent ppc = new ProcedurePerformerComponent();
        ppc.setActor(performer);
        CodeableConcept function = CommonUtil.findConceptFromCollectionUsingSimpleString(certifierType, ProcedureDeathCertificationUtil.certifierTypes);
        ppc.setFunction(function);
        this.addPerformer(ppc);
        return ppc;
    }
}
