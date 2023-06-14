package hossein.bakand.domain.workers

import kotlinx.coroutines.flow.Flow

interface SyncStatusMonitor {
    val isSyncing: Flow<SyncStatus>
    fun requestSync()
}

enum class SyncStatus(val id: Int) {
    Success(id = 0),
    Running(id = 1),
    Failed(id = 2),
    Timeout(id = 3),
}
