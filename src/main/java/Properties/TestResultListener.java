package Properties;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener2;

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestResultListener implements IResultListener2 {
	
	
	



@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestSuccess(ITestResult result) {
	System.out.println("SUCCESS!!!");
	
}

@Override
public void onTestFailure(ITestResult result) {
	System.out.println("FAILURE!!!");
	IWebAppTest test;
	if (result.getInstance() instanceof IWebAppTest){
	test = IWebAppTest.class.cast(result.getInstance());
	File screenshot = test.getTestedApp().makeScreenshot();
	allureScreenshot(screenshot, "Failure Screenshot");
	 
	}
}
	@Attachment("{1}")
	private byte[] allureScreenshot(File screen, String name){
		try {return FileUtils.readFileToByteArray(screen);}
		catch (Exception e){
			return null;
		}
	}


@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}

@Override
public void onConfigurationSuccess(ITestResult itr) {
	// TODO Auto-generated method stub
	
}

@Override
public void onConfigurationFailure(ITestResult itr) {
	// TODO Auto-generated method stub
	
}

@Override
public void onConfigurationSkip(ITestResult itr) {
	// TODO Auto-generated method stub
	
}

@Override
public void beforeConfiguration(ITestResult tr) {
	// TODO Auto-generated method stub
	
}
}
