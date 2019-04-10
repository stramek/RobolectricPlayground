package pl.marcin.robolectricresearch

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.contrib.DrawerActions.open
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {

    @Test
    fun shouldEditTextPersistLifecycle() {
        val textToTest = "Text"
        val scenario = launchActivity<MainActivity>()

        onView(withId(R.id.editText)).perform(typeText(textToTest))
        scenario.recreate()
        onView(withId(R.id.editText)).check(matches(withText(textToTest)))
    }

    @Test
    fun shouldShowSnackbarOnFabClick() {
        val scenario = launchActivity<MainActivity>()

        onView(withId(R.id.fab)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Replace with your own action")))
    }

    @Test
    fun shouldEditTextPersistLifecycleInFragment() {
        val textToTest = "Text"
        val scenario = launchFragmentInContainer<MainFragment>(
            themeResId = R.style.AppTheme
        )

        onView(withId(R.id.editText)).perform(typeText(textToTest))
        scenario.recreate()
        onView(withId(R.id.editText)).check(matches(withText(textToTest)))
    }

    @Test
    fun shouldChangeTestAfterClickingButton() {
        val scenario = launchFragmentInContainer<MainFragment>(
            themeResId = R.style.AppTheme
        )

        onView(withId(R.id.editText)).check(matches(withText("")))
        onView(withId(R.id.fillBt)).perform(click())
        onView(withId(R.id.editText)).check(matches(withText(R.string.test_string)))
    }

    @Test
    fun shouldFillInputOnFillClick() {
        launchFragmentInContainer<MainFragment>(themeResId = R.style.AppTheme)

        onView(withId(R.id.editText)).check(matches(ViewMatchers.withHint("This is a hint")))
        onView(withId(R.id.editText)).check(matches(withText("")))
        onView(withId(R.id.fillBt)).perform(click())
        onView(withId(R.id.editText)).check(matches(withText(R.string.test_string)))
        onView(withId(R.id.clearBt)).perform(click())
        onView(withId(R.id.editText)).check(matches(withText("")))
    }
}
