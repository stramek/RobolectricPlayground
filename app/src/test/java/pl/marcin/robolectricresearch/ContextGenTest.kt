package pl.marcin.robolectricresearch

import android.app.Application
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
class ContextGenTest {

    @Test
    fun shouldCreateContext() {
        val controller = TestController()

        controller.doSomething(ApplicationProvider.getApplicationContext<Application>())
    }

    @Test
    fun shouldStartService() {
        val controller = TestController()

        val shadowApp = Shadows.shadowOf(ApplicationProvider.getApplicationContext<Application>())
        controller.startService(RuntimeEnvironment.systemContext)
        val serviceIntent = shadowApp.peekNextStartedService()
        assertTrue(serviceIntent.assertService<ServiceToTest>())
    }

    inline fun <reified T> Intent?.assertService(): Boolean {
        return T::class.java.canonicalName == this?.component?.className
    }
}
