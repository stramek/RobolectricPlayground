package pl.marcin.robolectricresearch

import android.app.IntentService
import android.content.Intent

class ServiceToTest : IntentService("NAME") {

    override fun onHandleIntent(intent: Intent?) {
        println("Running service!")
    }
}