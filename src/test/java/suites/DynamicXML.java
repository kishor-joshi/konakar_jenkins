package suites;


	import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
	import org.testng.xml.XmlSuite;
	import org.testng.xml.XmlTest;

import com.konakart.testscenarios.SearchProductScenario;
import com.konakart.testscenarios.SpecificProductValidationScenario;

	
	public class DynamicXML {

		//Properties property;
	
		

		public void runTestNGTest(Map<String,String> testngParams)
		 {   //Create an instance on TestNG 
		     TestNG myTestNG = new TestNG();   
		     Map<String,String> testngParams1 = new HashMap<String,String>(); 
		 	testngParams1.put("browserType", "firefox");
		     //Create an instance of XML Suite and assign a name for it. 
		      XmlSuite mySuite = new XmlSuite(); 
		      mySuite.setName("MySuite"); 
		      mySuite.setParallel(XmlSuite.ParallelMode.TESTS);   

		     //Create an instance of XmlTest and assign a name for it.  
		     XmlTest myTest = new XmlTest(mySuite); 
		     myTest.setName("MyTest");   
		  
		     //Add any parameters that you want to set to the Test. 
		     myTest.setParameters(testngParams); 
		    // myTest.setParameters(""); 
		   
		     //Create a list which can contain the classes that you want to run.
		     List<XmlClass> myClasses = new ArrayList<XmlClass>();
		     myClasses.add(new XmlClass(SpecificProductValidationScenario.class));
		   //  myClasses.add(new XmlClass(SearchProductScenario.class));

		     //Assign that to the XmlTest Object created earlier. 
		     myTest.setXmlClasses(myClasses);   

		     //Create a list of XmlTests and add the Xmltest you created earlier to it.
		     List<XmlTest> myTests = new ArrayList<XmlTest>(); 
		     myTests.add(myTest);  
		   //  myTests.add(myTest);  

		     //add the list of tests to your Suite. 
		     mySuite.setTests(myTests);   

		     //Add the suite to the list of suites. 
		     List<XmlSuite> mySuites = new ArrayList<XmlSuite>(); 
		     mySuites.add(mySuite);   
		     
		     //Set the list of Suites to the testNG object you created earlier. 
		     myTestNG.setXmlSuites(mySuites);
		     mySuite.setFileName("myTemp.xml"); 
		     mySuite.setThreadCount(3);   
		     myTestNG.run();

		     //Create physical XML file based on the virtual XML content 
		     for(XmlSuite suite : mySuites) 
		     {  
		         createXmlFile(suite); 
		     }   
		     System.out.println("File generated successfully.");   
		 
		     //Print the parameter values 
		     Map<String,String> params = myTest.getParameters(); 
		     for(Map.Entry<String, String> entry : params.entrySet()) 
		     { 
		       System.out.println(entry.getKey() + " => " + entry.getValue()); 
		     }
		    }
		
		    //This method will create an Xml file based on the XmlSuite data 
		    public void createXmlFile(XmlSuite mSuite) 
		    { 
		       FileWriter writer; 
		       try { 
		            writer = new FileWriter(new File("myTemp.xml")); 
		            writer.write(mSuite.toXml()); 
		            writer.flush(); 
		            writer.close(); 
		            System.out.println(new File("myTemp.xml").getAbsolutePath());
		           } catch (IOException e)
		            {
		              e.printStackTrace(); 
		            }
		    }
@Test
public void set() throws IOException {
	//SearchProductScenario s=new SearchProductScenario();
	//runTestFile(s);
	Map<String,String> testngParams = new HashMap<String,String>(); 
	testngParams.put("browserType", "firefox");
	//testngParams.put("browserType", "chrome");
	runTestNGTestModified(testngParams);
	
		
	
}
public void runTestFile(Object classObject) throws IOException {
	//Properties property = ReadPropertiesFile.loadProperty("D:\\java_training\\com.konakart\\config.properties");

	List<String> browserList = new ArrayList<String>();
	String[] browserArray = {"ie"};
	for (String browserName : browserArray) {
		browserList.add(browserName);
	}

	XmlSuite xmlSuite = new XmlSuite();
	xmlSuite.setName("suite");
	xmlSuite.setVerbose(1);
	xmlSuite.setParallel("tests");
	xmlSuite.setThreadCount(3);

	List<XmlSuite> suites = new ArrayList<XmlSuite>();

	for (String browserName : browserList) {

		XmlTest xmlTest = new XmlTest(xmlSuite);
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("browser", browserName);
		xmlTest.setParameters(parameter);
		xmlTest.setName("Test search product availability and validate " + browserName);			
		// code to read your testNg file

		XmlClass xmlClass = new XmlClass(classObject.getClass());
		List<XmlClass> xmlClassList = new ArrayList<XmlClass>();
		xmlClassList.add(xmlClass);
		xmlTest.setXmlClasses(xmlClassList);

	}

	suites.add(xmlSuite);

	TestNG testng = new TestNG();

	testng.setXmlSuites(suites);

	testng.run();

}
public void runTestNGTestModified(Map<String,String> testngParams)
{   //Create an instance on TestNG 
    TestNG myTestNG = new TestNG(); 
   
    Map<String,String> testngParams1 = new HashMap<String,String>(); 
	testngParams1.put("browserType", "ie");
    //Create an instance of XML Suite and assign a name for it. 
     XmlSuite mySuite = new XmlSuite(); 
     mySuite.setName("MySuite"); 
     mySuite.setParallel(XmlSuite.ParallelMode.TESTS);   

    //Create an instance of XmlTest and assign a name for it.  
    XmlTest myTest = new XmlTest(mySuite); 
    myTest.setName("MyTest"); 
  //Create an instance of XmlTest and assign a name for it.  
    XmlTest myTest1 = new XmlTest(mySuite); 
    myTest1.setName("MyTest1"); 
 
    //Add any parameters that you want to set to the Test. 
    myTest.setParameters(testngParams); 
    myTest1.setParameters(testngParams1);
    
   // myTest.setParameters(""); 
  
    //Create a list which can contain the classes that you want to run.
    List<XmlClass> myClasses = new ArrayList<XmlClass>();
    myClasses.add(new XmlClass(SpecificProductValidationScenario.class));
  //  myClasses.add(new XmlClass(SearchProductScenario.class));

    //Assign that to the XmlTest Object created earlier. 
    myTest.setXmlClasses(myClasses);   
    myTest1.setXmlClasses(myClasses);   

    //Create a list of XmlTests and add the Xmltest you created earlier to it.
    List<XmlTest> myTests = new ArrayList<XmlTest>(); 
    myTests.add(myTest);  
    myTests.add(myTest1);  

    //add the list of tests to your Suite. 
    mySuite.setTests(myTests);   

    //Add the suite to the list of suites. 
    List<XmlSuite> mySuites = new ArrayList<XmlSuite>(); 
    mySuites.add(mySuite);   
    
    //Set the list of Suites to the testNG object you created earlier. 
    myTestNG.setXmlSuites(mySuites);
    
    
    mySuite.setFileName("myTemp.xml"); 
    mySuite.setThreadCount(3);   
    myTestNG.run();
   

    //Create physical XML file based on the virtual XML content 
    for(XmlSuite suite : mySuites) 
    {  
        createXmlFile(suite); 
    }   
    System.out.println("File generated successfully.");   

    //Print the parameter values 
    Map<String,String> params = myTest.getParameters(); 
    for(Map.Entry<String, String> entry : params.entrySet()) 
    { 
      System.out.println(entry.getKey() + " => " + entry.getValue()); 
    }
   }

   

	}

