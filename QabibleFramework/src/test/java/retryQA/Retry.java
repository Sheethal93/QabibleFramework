package retryQA;

import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry {
	int counter = 0;
	int retryLimit = 4;
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}	
	
}
