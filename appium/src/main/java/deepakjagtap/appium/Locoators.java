package deepakjagtap.appium;

public interface Locoators {
	public static final String VIEWS = "Views";
	public static final String PREFERENCE = "Preference";
	public static final String VISIBILITY = "Visibility";
	public static final String PREFERENCE_DEPENDENCIES = "3. Preference dependencies";
	public static final String CHECK_WIFI_CHECKBOX = "android:id/checkbox";
	public static final String WIFI_SETTING = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]";
	public static final String INPUT_BOX = "android:id/edit";
	public static final String TEXT_WIFI_SETTING = "android:id/alertTitle";
	public static final String OK = "android:id/button1";
	public static final String VIEW_VISIBILITY = "//android.widget.TextView[@text='Views/Visibility']";
	public static final String ANDROID_UI_AUTOMATOR_WEB_VIEW = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))";
	public static final String WEB_VIEW = "//android.widget.TextView[@text=\"Views/WebView\"]";

	public static final String EXPANDABLE_LISTS = "Expandable Lists";
	public static final String CUSTOM_ADAPTER = "1. Custom Adapter";
	public static final String SAMPLE_MENU = "//android.widget.TextView[@text='Sample menu']";

	public static final String PEOPLE_NAMES = "//android.widget.TextView[@text='People Names']";
}