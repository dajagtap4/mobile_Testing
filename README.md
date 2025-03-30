

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

# Test Excecution using maven commands

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
