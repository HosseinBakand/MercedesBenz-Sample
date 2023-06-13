package hossein.bakand.ui.carlist.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.Market
import hossein.bakand.domain.usecases.FetchMarketsUseCase
import hossein.bakand.domain.usecases.ObserveMarketsUseCase
import hossein.bakand.domain.workers.SyncStatus
import hossein.bakand.domain.workers.SyncStatusMonitor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    observeMarketsUseCase: ObserveMarketsUseCase,
    private val fetchMarketsUseCase: FetchMarketsUseCase,
    private val syncStatusMonitor: SyncStatusMonitor,
) : ViewModel() {

    val syncingState = syncStatusMonitor.isSyncing.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        SyncStatus.Running
    )

    val uiState: StateFlow<MarketUiState> =
        observeMarketsUseCase()
            .catch { emit(emptyList()) }
            .map {
                if (it.isEmpty()) {
                    initialData()
                    MarketUiState.Loading
                } else {
                    MarketUiState.Success(markets = it)
                }

            }.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                MarketUiState.Loading
            )

    private fun initialData() {
        viewModelScope.launch {
            fetchMarketsUseCase(Unit)
        }
    }
}

sealed class MarketUiState {
    data class Success(
        val markets: List<Market> = emptyList()
    ) : MarketUiState()

    object Loading : MarketUiState()
}
