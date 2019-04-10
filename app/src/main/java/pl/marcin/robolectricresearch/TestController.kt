package pl.marcin.robolectricresearch

import android.content.Context
import android.content.Intent
import android.util.Log

class TestController {

    fun doSomething(context: Context) {
        println("Doing something with context! $context")
    }

    fun startService(context: Context) {
        context.startService(Intent(context, ServiceToTest::class.java))
    }
}
