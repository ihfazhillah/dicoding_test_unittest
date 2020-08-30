package com.ihfazh.dicodinglatihantesting;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private final String dummyVolume = "504.0";
    private final String dummyCircumference = "100.0";
    private final String dummySurfaceArea = "396.0";
    private final String dummyLength = "12.0";
    private final String dummyWidth = "7.0";
    private final String dummyHeight = "6.0";
    private final String emptyInput = "";
    private final String fieldEmpty = "Field ini tidak boleh kosong";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void assertGetCircumference(){
        onView(withId(R.id.et_panjang)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.et_lebar)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.et_tinggi)).perform(typeText(dummyHeight), closeSoftKeyboard());

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_htg_keliling)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_htg_keliling)).perform(click());

        onView(withId(R.id.tv_hasil)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_hasil)).check(matches(withText(dummyCircumference)));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ihfazh.dicodinglatihantesting", appContext.getPackageName());
    }
}