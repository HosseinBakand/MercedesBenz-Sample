package hossein.bakand.ui.carlist.models

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import hossein.bakand.ui.carlist.markets.MarketUiState
import hossein.bakand.ui.carlist.navigtion.CarListDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    marketRepository: MarketRepository
) : ViewModel() {
    private val marketId: String = savedStateHandle[CarListDestination.marketIdArg] ?: ""

    val uiState: StateFlow<CarListUiState> =
        marketRepository.getMarketModels(marketId)
            .map { CarListUiState(carModels = it) }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                CarListUiState()
            )

    init {
        viewModelScope.launch {
            marketRepository.updateMarketCarModels(marketId)
        }
    }
}

data class CarListUiState(
    val carModels: List<CarModel> = emptyList()
)
