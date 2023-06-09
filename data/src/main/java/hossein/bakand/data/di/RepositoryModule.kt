package hossein.bakand.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hossein.bakand.data.repositoriesImpl.MarketRepositoryImpl
import hossein.bakand.domain.repositories.MarketRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getMarketRepository(repository: MarketRepositoryImpl):MarketRepository
}