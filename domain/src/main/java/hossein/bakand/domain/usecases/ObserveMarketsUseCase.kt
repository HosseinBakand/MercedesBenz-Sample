package hossein.bakand.domain.usecases

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import hossein.bakand.core.common.qualifiers.IoDispatcher
import hossein.bakand.core.designsystem.R
import hossein.bakand.data.model.Market
import hossein.bakand.domain.repositories.MarketRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import org.json.JSONArray
import java.io.InputStream
import javax.inject.Inject

class ObserveMarketsUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    private val fetchMarketsUseCase: FetchMarketsUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context,
) : ObservableUseCase<List<Market>>(ioDispatcher) {
    override fun createObservable(): Flow<List<Market>> {
        return marketRepository.getAllMarket().onStart {
            fetchMarketsUseCase(Unit)
        }.onEach {
            it.ifEmpty {
                marketRepository.insertFromJson(context = context)
            }
        }
    }
    suspend fun prePopulateUsers(context: Context) {

    }
}
