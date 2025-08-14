NOTE - Consider as appium setup is done.
now learn about appium 

> Configure Appium

```
AppiumDriverLocalService service = new AppiumServiceBuilder()
		.withAppiumJS(new File("< Main.js file path >"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();

service.start();
```

> Main.js path : 
> C://Users//Administrator//AppData//Roaming//npm//node_modules//appium//build//lib//main.js

`AppiumDriverLocalService`
```
It is a class in Appium’s Java client library that start and manage an Appium server programmatically from your test code.

import io.appium.java_client.service.local.AppiumDriverLocalService;

Instead of manually starting Appium from the command line, you can use AppiumDriverLocalService to launch and stop the Appium server within your automation script.
```

`AppiumServiceBuilder`
```
AppiumServiceBuilder is a helper class which builds the configuration for the Appium server, and it's passed to AppiumDriverLocalService to start it.

import io.appium.java_client.service.local.AppiumServiceBuilder;
```

```
UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android Device");
		options.setChromedriverExecutable("< chromedriver path>");
		options.setApp(".apk path");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```
 `ChromeDriver Path`
> C://Users//deepak.jagtap//Downloads//chromedriver-win64 (1)//chromedriver-win64//chromedriver.exe

`.apk path`
> C://Users//deepak.jagtap//eclipse-workspace2//appium2//src//test//java//resources//ApiDemos-debug.apk

`UiAutomator2Options`
```
It is a class used to define desired capabilities for the UiAutomator2 driver, UiAutomator2 is Appium’s default automation engine for Android.
```

### Install apk app in Emulator

```
C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\platform-tools>adb install C:\Users\deepak.jagtap\Downloads\paytm-bhim-upi-money-transfer-mobile-recharge.apk
Performing Streamed Install
Success
```
