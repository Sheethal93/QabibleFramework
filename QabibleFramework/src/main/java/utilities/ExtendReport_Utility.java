package utilities;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport_Utility implements ITestListener {

    // Declaring ExtentReport-related objects
    ExtentSparkReporter sparkReporter; // Responsible for generating the HTML report
    ExtentReports reports;             // Main ExtentReports object
    ExtentTest test;                   // Represents individual test cases

    @Override
    public void onTestStart(ITestResult result) {
        // Executes before each @Test method begins
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Executes when a test passes
        test = reports.createTest(result.getName()); // Create entry for the test
        test.log(Status.PASS, MarkupHelper.createLabel(
                "Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN)); // Log as passed
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Executes when a test fails
        test = reports.createTest(result.getName()); // Create entry
        test.log(Status.FAIL, MarkupHelper.createLabel(
                "Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED)); // Log as failed
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Executes when a test is skipped
        test = reports.createTest(result.getName()); // Create entry
        test.log(Status.SKIP, MarkupHelper.createLabel(
                "Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW)); // Log as skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Usually used for flaky tests (not common in practice)
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Executes when a test fails due to timeout
    }

    @Override
    public void onStart(ITestContext context) {
        // Executes once before any test runs

        // Generate timestamp for report name
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

        // Create path for report directory using platform-independent method
        Path reportDirPath = Paths.get(System.getProperty("user.dir"), "ExtentReport");
        File reportDir = reportDirPath.toFile();

        // Create directory if it doesn't exist
        if (!reportDir.exists()) {
            reportDir.mkdir();
        }

        // Create full file path for the report file (e.g., ExtentReport_01_05_2025_10_45_32.html)
        Path reportFilePath = reportDirPath.resolve("ExtentReport_" + timeStamp + ".html");

        // Initialize spark reporter with the final path
        sparkReporter = new ExtentSparkReporter(reportFilePath.toString());

        // Initialize main ExtentReports instance and attach reporter
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);

        // Add system/environment info to the report
        reports.setSystemInfo("PC Name", System.getenv("USER")); // Uses current system's user name
        reports.setSystemInfo("OS", System.getProperty("os.name")); // Fetches the OS name dynamically
        reports.setSystemInfo("Processor",
                System.getenv("PROCESSOR_IDENTIFIER") != null ? System.getenv("PROCESSOR_IDENTIFIER") : "Unknown");

        // Configure report appearance
        sparkReporter.config().setDocumentTitle("***Extent Report Sample***"); // Browser tab title
        sparkReporter.config().setReportName("***Report Summary***"); // Report title in HTML
        sparkReporter.config().setTheme(Theme.DARK); // Use dark theme
    }

    @Override
    public void onFinish(ITestContext context) {
        // Executes after all tests are done
        reports.flush(); // Finalizes the report and writes everything to the HTML file
    }
}
