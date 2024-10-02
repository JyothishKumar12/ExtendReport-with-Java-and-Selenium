import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter4styles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extentReports = new ExtentReports();
		File file = new File("./Reports/report2.html");
		ExtentSparkReporter exSparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(exSparkReporter);
		extentReports.createTest("Text based test")
		.log(Status.FAIL,"<b><i>PASSED<i></b>");
	
		
		
//		Xml and json 
		String json = "{\"employees\":[\r\n"
				+ "  { \"firstName\":\"John\", \"lastName\":\"Doe\" },\r\n"
				+ "  { \"firstName\":\"Anna\", \"lastName\":\"Smith\" },\r\n"
				+ "  { \"firstName\":\"Peter\", \"lastName\":\"Jones\" }\r\n"
				+ "]}";
		
		
		
		extentReports.createTest("Json test ").info(MarkupHelper.createCodeBlock(json));
		
		String xml ="<employees>\r\n"
				+ "  <employee>\r\n"
				+ "    <firstName>John</firstName> <lastName>Doe</lastName>\r\n"
				+ "  </employee>\r\n"
				+ "  <employee>\r\n"
				+ "    <firstName>Anna</firstName> <lastName>Smith</lastName>\r\n"
				+ "  </employee>\r\n"
				+ "  <employee>\r\n"
				+ "    <firstName>Peter</firstName> <lastName>Jones</lastName>\r\n"
				+ "  </employee>\r\n"
				+ "</employees>";
		extentReports.createTest("xml test").info(MarkupHelper.createCodeBlock(xml));
		extentReports.flush();
		
		extentReports.createTest("Highlight test").info(MarkupHelper.createLabel("passed",ExtentColor.GREEN));
		
		try {
			int c = 5/0;
		}
		catch (Exception e){
			
			extentReports
			.createTest("Exception test")
			.fail(e);
		}
		
		extentReports.flush();
	}

}
