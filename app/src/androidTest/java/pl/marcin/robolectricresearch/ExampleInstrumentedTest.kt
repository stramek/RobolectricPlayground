package pl.marcin.robolectricresearch

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

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

        onView(withId(R.id.editText)).check(matches(withHint("This is a hint")))
        onView(withId(R.id.editText)).check(matches(withText("")))
        onView(withId(R.id.fillBt)).perform(click())
        onView(withId(R.id.editText)).check(matches(withText(R.string.test_string)))
        onView(withId(R.id.clearBt)).perform(click())
        onView(withId(R.id.editText)).check(matches(withText("")))
    }

    @Test
    fun shouldClickOnNavItem() {
        launchActivity<MainActivity>()
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed())).perform(open())
        onView(withId(R.id.nav_view)).check(matches(isDisplayed())).perform(navigateTo(R.id.nav_send))
    }
}
