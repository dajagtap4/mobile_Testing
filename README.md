# Mobile Testing with appium setup

## Pre requisites

### Android studio
  add env path for this

  `ANDROID_HOME` - 
  
  C:\Users\deepak.jagtap\AppData\Local\Android\Sdk

  `paths` - 

   C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\tools\bin
   C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\tools
   C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\platform-tools
   C:\Program Files\nodejs\node_modules\npm\bin

## appium inspector

download it from below link 

```
https://github.com/appium/appium-inspector/releases
```
install this for windows

`Appium-Inspector-2025.3.1-win-x64.exe`


### install .apk app in semulator/emulator through cmd

```
C:\Users\deepak.jagtap\AppData\Local\Android\Sdk\platform-tools>adb install C:\Users\deepak.jagtap\Downloads\General-Store.apk
Performing Streamed Install
Success
```

### Command to get package and activity 

```
C:\Users\deepak.jagtap>adb shell dumpsys window | find "mCurrentFocus"
  mCurrentFocus=Window{ca580ec u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
```
