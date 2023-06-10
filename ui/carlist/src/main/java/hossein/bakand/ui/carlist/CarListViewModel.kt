package hossein.bakand.ui.carlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.Market
import hossein.bakand.ui.carlist.markets.MarketUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(MarketUiState())
    val uiState: StateFlow<MarketUiState> = _uiState
}

data class CarListUiState(
    val markets: List<Market> = emptyList()
)
