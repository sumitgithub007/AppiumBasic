package AppiumAutomation.Practise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {

	
	
	
	@Test 
	public void AppiumTest() throws MalformedURLException, InterruptedException
	{
		//check ram of your laptop atleast 18 GB
		
		//Note : Before this run one emulator from android studio and 
		//run command adb devices ,if you see like List of devices attached 
												   //emulator-5554 device (name can be different)		
												  //then only proceed
		
		
	
		
		Map<String,String> env = new HashMap<String,String>(System.getenv());
		//env.put("ANDROID_HOME", "C:\\Users\\goyal\\AppData\\Local\\Android\\Sdk");
		//env.put("JAVA_HOME", "C:\\Program Files\\jdk-17.0.7");
		
		String main_js_path = "C:\\Users\\goyal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";	
		
	 AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(main_js_path))
			 .withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).build();
		
	 service.start();
		String path_App=	System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk";
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MobileDevice");
		options.setApp(path_App);
	 
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	//Thread.sleep(66666);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.quit();
	service.stop();
		
	}
	
	
}
