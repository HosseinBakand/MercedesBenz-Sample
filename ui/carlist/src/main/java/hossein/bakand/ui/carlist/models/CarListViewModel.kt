package hossein.bakand.ui.carlist.models

import android.util.Log
import android.util.Range
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hossein.bakand.data.model.CarModel
import hossein.bakand.data.model.VehicleBody
import hossein.bakand.data.model.VehicleClass
import hossein.bakand.domain.repositories.MarketRepository
import hossein.bakand.domain.usecases.FetchMarketCarModelsUseCase
import hossein.bakand.domain.usecases.GetMarketCarModelsUseCase
import hossein.bakand.domain.usecases.ToggleBookmarkCarUseCase
import hossein.bakand.ui.carlist.navigtion.CarListDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CarListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMarketCarModelsUseCase: GetMarketCarModelsUseCase,
    private val fetchMarketCarModelsUseCase: FetchMarketCarModelsUseCase,
    private val toggleBookmarkCarUseCase: ToggleBookmarkCarUseCase,
) : ViewModel() {
    private val marketId: String = savedStateHandle[CarListDestination.marketIdArg] ?: ""

    private val _selectedClassState = MutableStateFlow(0)

    private val _filterState = MutableStateFlow(FilterState())
    val filterState: StateFlow<FilterState> = _filterState

    private val marketCarModels = getMarketCarModelsUseCase.flow
        .onStart { getMarketCarModelsUseCase.invoke(marketId) }
        .catch { emit(emptyList()) }
    val uiState: StateFlow<CarListUiState> =
        combine(
            marketCarModels,
            _selectedClassState,
            filterState
        ) { carModels, selectedIndex, filters ->
            val classes = carModels.map { it.vehicleClass }.toSet()
            val selectedClassCars =
                carModels.filter { car ->
                    car.vehicleClass == classes.elementAt(selectedIndex) &&
                            filters.brands.find { it.first == car.brand }?.second == true &&
                            filters.bodies.find { it.first == car.vehicleBody }?.second == true &&
                            car.priceInformation.price.toFloat() in filters.selectedPriceRange
                }
            Log.e("TAGTAG", selectedClassCars.map { it.isBookmarked }.toString())
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
            fetchMarketCarModelsUseCase(marketId)
        }
        marketCarModels.onEach { cars ->
            val minPrice: Float =
                cars.map { it.priceInformation.price }.minOrNull()?.toFloat() ?: 0f
            val maxPrice: Float =
                cars.map { it.priceInformation.price }.maxOrNull()?.toFloat() ?: 0f
            _filterState.update {
                it.copy(
                    brands = cars.map { it.brand to true }.toSet(),
                    bodies = cars.map { it.vehicleBody to true }.toSet(),
                    priceRange = Range(minPrice, maxPrice),
                    selectedPriceRange = Range(minPrice, maxPrice),
                )
            }
        }.launchIn(viewModelScope)
    }

    fun setSelectedClass(index: Int) {
        _selectedClassState.update {
            index
        }
    }

    fun changeBrandFilter(brand: String) {
        _filterState.update { state ->
            val pair = state.brands.find { it.first == brand }!!
            val newSelectedBrands =
                state.brands.minus(pair).plus(pair.copy(second = !pair.second))

            state.copy(
                brands = newSelectedBrands,
            )
        }
    }

    fun changeBodyFilter(body: String) {
        _filterState.update { state ->
            val pair = state.bodies.find { it.first.bodyName == body }!!
            val newSelectedBodies: Set<Pair<VehicleBody, Boolean>> =
                state.bodies
                    .minus(pair)
                    .plus(pair.copy(second = !pair.second))
            state.copy(
                bodies = newSelectedBodies,
            )
        }
    }

    fun changePriceRangeFilter(priceRange: Range<Float>) {
        _filterState.update {
            it.copy(
                selectedPriceRange = priceRange
            )
        }
    }

    fun bookmarkCar(carModel: CarModel) {
        viewModelScope.launch {
            toggleBookmarkCarUseCase(carModel)
        }
    }
}

data class CarListUiState(
    val carModels: List<CarModel> = emptyList(),
    val carClasses: Set<VehicleClass> = emptySet(),
    val selectedClassInx: Int = 0,
)

data class FilterState(
    val priceRange: Range<Float> = Range(0f, 0f),
    val selectedPriceRange: Range<Float> = Range(0f, 0f),
    val brands: Set<Pair<String, Boolean>> = emptySet(),
    val bodies: Set<Pair<VehicleBody, Boolean>> = emptySet(),
)
