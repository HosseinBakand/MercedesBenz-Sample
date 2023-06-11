

package hossein.bakand.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hossein.bakand.data.database.MercedesBenzDatabase
import hossein.bakand.data.database.daos.CarModelDao
import hossein.bakand.data.database.daos.MarketDao


@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesMarketDao(
        database: MercedesBenzDatabase,
    ): MarketDao = database.marketDao()
    @Provides
    fun providesCarModelDao(
        database: MercedesBenzDatabase,
    ): CarModelDao= database.carModelDao()
}
