package edu.gatech.MDI;


import edu.gatech.chai.MDI.context.MDIFhirContext;
import edu.gatech.chai.MDI.model.resource.BundleDocumentMDIToEDRS;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	MDIFhirContext context;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	super( testName );
    	context = new MDIFhirContext();
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
}