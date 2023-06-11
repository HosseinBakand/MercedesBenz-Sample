package hossein.bakand.ui.carlist.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    marketRepository: MarketRepository
) : ViewModel() {

    val uiState: StateFlow<MarketUiState> =
        marketRepository.getAllMarket()
            .catch { emit(emptyList()) }
            .map { MarketUiState(markets = it) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                MarketUiState()
            )

    init {
        viewModelScope.launch {
            marketRepository.updateMarkets()
        }
    }
}

data class MarketUiState(
    val markets: List<Market> = emptyList()
)
