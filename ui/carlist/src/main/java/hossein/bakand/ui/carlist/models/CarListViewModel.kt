package hossein.bakand.ui.carlist.models

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.Market
import hossein.bakand.data.model.VehicleClass
import hossein.bakand.domain.repositories.MarketRepository
import hossein.bakand.ui.carlist.markets.MarketUiState
import hossein.bakand.ui.carlist.navigtion.CarListDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    marketRepository: MarketRepository
) : ViewModel() {
    private val marketId: String = savedStateHandle[CarListDestination.marketIdArg] ?: ""

    private val _selectedClassState = MutableStateFlow(0)

    val uiState: StateFlow<CarListUiState> =
        combine(
            marketRepository.getMarketModels(marketId),
            _selectedClassState
        ) { carModels, selectedIndex ->
            val classes = carModels.map { it.vehicleClass }.toSet()
            Log.e("TAGTAG", classes.map { it.classID }.toString())
            val selectedClassCars =
                carModels.filter { it.vehicleClass == classes.elementAt(selectedIndex) }
            CarListUiState(
                carModels = selectedClassCars,
                carClasses = classes,
                selectedClassInx = selectedIndex
            )
        }
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

    fun setSelectedClass(index: Int) {
        _selectedClassState.update {
            index
        }
    }
}

data class CarListUiState(
    val carModels: List<CarModel> = emptyList(),
    val carClasses: Set<VehicleClass> = emptySet(),
    val selectedClassInx: Int = 0,
)
