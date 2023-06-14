package hossein.bakand.workmanager.sync

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkInfo
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import hossein.bakand.domain.workers.SyncStatus
import hossein.bakand.domain.workers.SyncStatusMonitor
import hossein.bakand.workmanager.initializers.SyncWorkName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import javax.inject.Inject

class WorkManagerSyncStatusMonitor @Inject constructor(
    @ApplicationContext private val context: Context,
) : SyncStatusMonitor {
    override val isSyncing: Flow<SyncStatus> =
        WorkManager.getInstance(context).getWorkInfosForUniqueWorkLiveData(SyncWorkName)
            .map(MutableList<WorkInfo>::getStatus)
            .asFlow()
            .conflate()

    override fun requestSync() {
        val workManager = WorkManager.getInstance(context)
        workManager.enqueueUniqueWork(
            SyncWorkName,
            ExistingWorkPolicy.KEEP,
            SyncWorker.startUpSyncWork(),
        )
    }
}
private fun List<WorkInfo>.getStatus(): SyncStatus {
    first().let {
        val data = it.outputData.getInt(SyncWorkName, SyncStatus.Running.id).let {
            SyncStatus.values().find { item -> item.id == it } ?: SyncStatus.Running
        }
        return when (it.state) {
            WorkInfo.State.SUCCEEDED -> SyncStatus.Success
            WorkInfo.State.RUNNING -> SyncStatus.Running
            WorkInfo.State.ENQUEUED -> SyncStatus.Running
            else -> SyncStatus.Failed
        }
    }
}

