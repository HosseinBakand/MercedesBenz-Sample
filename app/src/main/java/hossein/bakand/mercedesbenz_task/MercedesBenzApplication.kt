package hossein.bakand.mercedesbenz_task

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hossein.bakand.workmanager.initializers.StartUpWorkers

@HiltAndroidApp
class MercedesBenzApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        StartUpWorkers.initialize(context = this)
    }
}