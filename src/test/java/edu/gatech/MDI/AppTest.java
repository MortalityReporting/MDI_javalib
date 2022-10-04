package edu.gatech.MDI;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.context.ConfigurationException;
import ca.uhn.fhir.parser.DataFormatException;
import ca.uhn.fhir.parser.IParser;
import edu.gatech.chai.MDI.context.MDIFhirContext;
import edu.gatech.chai.MDI.model.resource.BundleDocumentMDIToEDRS;
import edu.gatech.chai.MDI.model.resource.ObservationCauseOfDeathPart1;
import edu.gatech.chai.MDI.model.resource.ObservationMannerOfDeath;
import edu.gatech.chai.VRDR.context.VRDRFhirContext;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;
import edu.gatech.chai.VRDR.model.DeathDate;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.MannerOfDeath;
import edu.gatech.chai.VRDR.model.util.MannerOfDeathUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	VRDRFhirContext context;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	super( testName );
    	context = new VRDRFhirContext();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testProducingDeathCertificateDocument()
    {
    	BundleDocumentMDIToEDRS bundle = BuildMDIToEdrsDocument.buildExampleBundleDocumentMDIToEDRS();
    	String encoded = context.getCtx().newJsonParser().encodeResourceToString(bundle);
    	System.out.println(encoded);
    	assertTrue( true );
    }

    public void testMigrationFromVRDRToMDI()
    {
        IParser vrdrParser = new VRDRFhirContext().getCtx().newJsonParser();
        IParser mdiParser = new MDIFhirContext().getCtx().newJsonParser();

        MannerOfDeath vrdrManner = new MannerOfDeath(); //VRDR MannerOfDeath
        vrdrManner.setValue(MannerOfDeathUtil.VALUE_ACCIDENTAL);

        ObservationMannerOfDeath mdiManner = new ObservationMannerOfDeath(vrdrManner); //Constructor for MDI from VRDR

        String vrdrAsString = vrdrParser.encodeResourceToString(vrdrManner);
        String mdiAsString = mdiParser.encodeResourceToString(mdiManner);
        Coding vrdrOriginalConcept = ((CodeableConcept)vrdrManner.getValue()).getCodingFirstRep();
        System.out.println("Original VRDR Manner code: "+vrdrOriginalConcept.getCode() + "," + vrdrOriginalConcept.getDisplay());
        Coding mdiConvertedConcept = ((CodeableConcept)mdiManner.getValue()).getCodingFirstRep();
        System.out.println("Converted MDI Manner code: "+mdiConvertedConcept.getCode() + "," + mdiConvertedConcept.getDisplay());
        System.out.println("Original VRDR Resource:"+vrdrAsString);
        System.out.println("Converted MDI Resource:"+mdiAsString);
    }
    
    /*
    public void testConsumingDeathCertificateDocument()
    {
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource("Testcase_Certificate.json").getFile());
    	DeathCertificateDocument deathCertificateDocument = null;
		try {
			deathCertificateDocument = (DeathCertificateDocument) context.getCtx().newJsonParser().parseResource(new FileInputStream(file));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (DataFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	String encoded = context.getCtx().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded);
    	assertTrue( true );
    }*/
}