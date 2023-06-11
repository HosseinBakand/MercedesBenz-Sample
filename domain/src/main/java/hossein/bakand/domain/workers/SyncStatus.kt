package hossein.bakand.domain.workers

import kotlinx.coroutines.flow.Flow

interface SyncStatus {
    val isSyncing: Flow<Boolean>
    fun requestSync()
}
