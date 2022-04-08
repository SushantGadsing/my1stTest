package listenerPackage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseClasses.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener

{
	public void onTestFailure(ITestResult result) {
		String TCname = result.getName();
	System.out.println("Failed taste case name is "+result.getName());
	
	try {
		takeScreenshot(TCname);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void onTestSuccess(ITestResult result) {
		
	System.out.println("Success taste case name is "+result.getName());
	
	
	
	
	}
}
