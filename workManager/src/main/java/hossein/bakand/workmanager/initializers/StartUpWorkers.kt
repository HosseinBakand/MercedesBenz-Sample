package hossein.bakand.workmanager.initializers

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import hossein.bakand.workmanager.sync.SyncWorker

object StartUpWorkers {
    fun initialize(context: Context) {
        WorkManager.getInstance(context).apply {
            enqueueUniqueWork(
                SyncWorkName,
                ExistingWorkPolicy.KEEP,
                SyncWorker.startUpSyncWork(),
            )
        }
    }
}


internal const val SyncWorkName = "SyncWorkName"
