`Appium_Android_Framework_POM.zip`

Above project contains mobile testing with  
* Android mobile Testing,
* POM,
* .properties,
* jenkins,
* maven commands.
* Extent Reports
* Listners

> # Mobile Testing with Appium.

> ## Pre Requisites 
1. Java
2. Android Studio
3. Appium inspector
4. Eclipse IDE
5. Node js
---

> ## 1. Java
#### How to install java on Windows.


Go to below link
https://www.oracle.com/in/java/technologies/downloads/#jdk22-windows

select windows as OS 

click link behind x64 Installer

open downloaded file > double click on it > Next > Close

Now we have to set path in env variable.

select path from file location upto bin as below

`C:\Program Files\Java\jdk-22\bin`

Goto env variable > system variable > path > add path.

Check java is installed -
Open cmd > 

`java --version`
       -> Displays the Java Runtime Env. (JRE) version


`javac --version`
-> Displays  Java Compiler (javac) version.

### Done with Java
---
> ## 2. Android Studio

go to this link -> 
[Android studio for Win](https://developer.android.com/studio?gad_source=1&gclid=Cj0KCQjwtJ6_BhDWARIsAGanmKczynNuhQ4Pf0VJAHLch9oGUraNEOrCXKTdjk8f-mtN2MIwn-RrnxYaAgzeEALw_wcB&gclsrc=aw.ds) 

 Follow below steps :
1. click on `"Download android studio for Meerkat" `
2. New popup window will open 
3. navigate to extream bottom 
4. click on check box ->    `" I have read and agree with the above terms and conditions"  `  
5. Click on button `"Download android studio for Meerkat | 2024.3.1 Patch  1 for windows",`
6. `android-studio-2024.3.1.14-windows.exe` this file will dounload in download folder.


7. Double click on .exe file
8. "welcome to Android studio setup" popup window will open 
9. next > choose components window > next > config settings window > next > choose start menu folder > `install` > next > finish 

Android studio window will open,
Now we need to add path in env variable for `system variables` as below,

  `ANDROID_HOME` - 
  
  ```
  C:\Users\deepak.jagtap\AppData\Local\Android\Sdk
```
  `paths` - 
```
   C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\tools\bin
C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\tools
   C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\platform-tools
C:\Program Files\nodejs\node_modules\npm\bin
```
 ### Android Studio setup done 

---

> ## 3. Appium Inspector
go to this link -> 
[Appium Inspector for Win.](https://github.com/appium/appium-inspector/releases) 

Download this .exe file 
`Appium-Inspector-2025.3.1-win.exe`

1. Open downloaded .exe file 
2. win protected your pc popup win will display > Click on More info > Run anyway > Only for me > Finish. Done

Appium Inspector window will open, Add capabilities as below for multiple devices, Apps and many more 


---
Add Below capabilities for `ApiDemos-debug.apk` app, `Pixel 3a` device in JSON Representation in appium inspector.

```
{
  "appium:app": "C://Users//deepak.jagtap//eclipse-workspace//appium//src//test//java//resources//ApiDemos-debug.apk",
  "appium:deviceName": "Pixel 3a",
  "appium:platformName": "ANDROID",
  "appium:automationName": "UIAutomator2"
}
```
--- 
Add Below capabilities for `General-Store.apk` app, `Pixel 3a` device in JSON Representation in appium inspector.

```
{
  "appium:app": "C://Users//deepak.jagtap//eclipse-workspace//appium//src//test//java//resources//General-Store.apk",
  "appium:deviceName": "Pixel 3a",
  "appium:platformName": "ANDROID",
  "appium:automationName": "UIAutomator2",
  "appium:chromedriverAutodownload": true
}

```

> # Test Excecution using maven commands

Create `testng.xml` file in your selenium project 

Steps - 

1. Right click on project,
2. Testng,
3. Convert to testng,
4. Finish,

testng.xml file will create in your selenium project.

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Suite">
  <test thread-count="5" name="Test">

    <classes>
      <class name="org.deepakjagtap.TestCase"/>
    </classes>

  </test> <!-- Test -->
</suite> <!-- Suite -->

```

here we want to execute test from `TestCase` class only so we added it into testng file with proper path like `org.deepakjagtap.TestCase`.

add below code in pom.xml file for maven ,

`pom.xml`
```

<profiles>
	<profile>
		<id>smoke</id>
		<build>
			<pluginManagement>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-surefire-plugin</artifactId>
						<version>3.5.2</version>
						<configuration>
							<suiteXmlFiles>
								<suiteXmlFile>testng.xml</suiteXmlFile>
							</suiteXmlFiles>
						</configuration>
					</plugin>
				</plugins>
			</pluginManagement>
		</build>
	</profile>
</profiles>
```

here, we added `testng.xml` as `<suiteXmlFile>testng.xml</suiteXmlFile>` and given `<id>smoke</id>` so it will execute only testng.xml file and in testng.xml file we given 
` <class name="org.deepakjagtap.TestCase"/>` this class so only test of that class will excecute.

**_(there can be couple of testng.xml files like testng2.xml, testng_regression.xml)_**

5. open cmd terminal,
6. navigate to this project path,
 * right click on project,
 * properties,
 * copy full path,
 ```
 C:\Users\deepak.jagtap\eclipse-workspace\Appium_Android_Framework_POM
 ```
 * in cmd navigate to that project path as below
 ```
 cd C:\Users\deepak.jagtap\eclipse-workspace\Appium_Android_Framework_POM
 ```

 7. hit below command 
 ` npm test -Psmoke`

 note we given `<id>smoke</id>` in pom.xml.

 Done with maven 
 
---
---
> # Jenkins Setup

Click below link for Jenkins installation-
https://www.jenkins.io/download/

1. CLick on Windows optiom
2. Download will start 
3. Double click on jenkins.msi file which is downloaded,
* Next > Next > Run service as local system > Test Port > Next > Next > Next > Install.

4. Navigate to jenkins Localhost - http://localhost:8080/

5. Need to find key to unlock, 
* Navigate to below path,
```
C:\ProgramData\Jenkins\.jenkins\secrets\initialAdminPassword
```
6. Select "Install Suggested plugins"
* Getting Started.

 ## Execution  on jenkins 

New Item > enter item name > freestyle project >ok

add `description` like 
```
"CI/CD pipeline for building and testing the Android application."
```
click on `advanced `
below the `"Execute concurrent builds if necessary"`


click on 
`"Use custom workspace"`
add project path in `Directory` `"C:\Users\deepak.jagtap\eclipse-workspace\Appium_Android_Framework_POM"`

add command in `Build Steps` without mvn
```
test -Psmoke
```
save

---

---


> # Cloud Testing | BrowserStack

Create account on browserStack

Do some setup in Eclipse for browserStack

1. help > eclipse marketplace > browserstack > install.
2. Right click on project > browserstack > Integrate with app automate sdk > Enter `user name` and `access key ` > integrate 

`user name` and `access key ` will get in browserstack 

BUILD SUCCESS get in terminal 

.yaml file will created.


3. Need to upload our app in BS (BrowserStack)
4. in BS, upload app > upload it > `bs://b1a64584c8132cacf45c8b8576676db4eab5ab5e`
we will get above key 
5. open our project > open yaml file ( refresh project if not availabel) > paste like below 

`app: bs://b1a64584c8132cacf45c8b8576676db4eab5ab5e # BrowserStack Sample App`  at line 32 in yaml file.

now we can run our test in two ways 

### Method 1 -

Directly run from test case level li ke below 

```
public class TestCase extends BaseTest {
	@Test
    run |debuge
	public void verifyUserCanFillForm() {
		formPage.setNameField("Deepak QA");
		formPage.setGender("female");
		formPage.setCountrySelection("Antarctica");

		ProductCatalogue productCatalogue = formPage.submitForm();
		String actualProductTitle = productCatalogue.getProductTitle();
		Assert.assertEquals(actualProductTitle, "Products");
	}
}
```
click on run -> 
`run | debuge `

test will execute on BS

OR 

right click -> testcases.java -> run as -> testNG test 

test will execute on BS

### Method 2 -

Refer "Test Excecution using maven commands"

in this
README.md file search "Test Excecution using maven commands"

Done with BS

---

> # Extents Reports and Listners
add below dependancy in pom.xml file 
```
<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.2</version>
</dependency>
```
create class ExtentsReportsNG in "src/main/java/testutils/ExtentsReportsNG"

`ExtentsReportsNG`
```
package testutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("this is report name");
		reporter.config().setDocumentTitle("this is document title");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "deepak jagtap");
		return extent;
	}
}
```

create Listners Interface in same package 

`Listeners`
```
package testutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	ExtentReports extent = ExtentsReportsNG.getReportObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getMethod().getMethodName());
		System.out.println("Cause: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed but within success percentage: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

```

now we are ready with extents report setup and we are using Listners interface for 


### 1. Centralized Reporting
Instead of adding reporting logic to each test, you can centralize it in the listener. This keeps your tests clean and focused on test logic, while the listener handles reporting.

### 2. Automated Actions on Test Events
You can perform custom actions automatically when certain events occur:

Before/After Test Execution: For setup and teardown operations.

On Test Start/Finish: To log test metadata, take screenshots, or update reports.

On Test Failure: To capture screenshots, log errors, or collect debug information.

### 3. Reusable Across Test Classes
Once implemented, the listener can be used across all tests without repeating code.

### 4. Integration with Extent Reports (or any reporting tool)
Listeners are perfect for integrating with tools like Extent Reports. They ensure that each test’s status is logged automatically without manually adding log statements in each test case.

---

add listners path in testng.xml <"profile"> in pom.xml so we c directly execute tests with `maven mvn test -Plistners`

`Testng_listners.xml`
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">

	<listeners>
		<listener class-name="org.deepakjagtap.utils.Listeners"></listener>
	</listeners>

	<test thread-count="5" name="Test">
		<classes>
			<class name="org.deepakjagtap.TestCase" />
		</classes>
	</test> <!--
	Test -->
</suite> <!--
Suite -->
```

`pom.xml`

```
<profile>
			<id>listners</id>
			<build>
				<pluginManagement>
					<plugins>
						<plugin>
							<groupId>org.apache.maven.plugins</groupId>
							<artifactId>maven-surefire-plugin</artifactId>
							<version>3.5.2</version>
							<configuration>
								<suiteXmlFiles>
									<suiteXmlFile>testng.listners.xml</suiteXmlFile>
								</suiteXmlFiles>
							</configuration>
						</plugin>
					</plugins>
				</pluginManagement>
			</build>
		</profile>
```

maven command - `mvn test -Plistners`

for maven execution refer "Test Excecution using maven commands" from this readme.md file.

Done with extent reports and Listners.

---
---
---

> ## Directly navigate to Disired page with Activity()

```
@Test
	public void directlyNavigateToDesiredPageWith_startActivity() {
        
		((JavascriptExecutor) driver).executeScript("mobile:startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.app.ActionBarTabs"));

	}
```
How to get this `"io.appium.android.apis/io.appium.android.apis.app.ActionBarTabs"`

open android studio emulator where you want to go directly > go to cmd > enter below command

`adb shell dumpsys window | grep -E 'mCurrentFocus'`

try below if above not work

`adb shell dumpsys window | findstr "mCurrentFocus"`

---
