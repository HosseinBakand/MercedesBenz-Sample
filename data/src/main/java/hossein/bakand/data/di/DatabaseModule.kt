package hossein.bakand.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hossein.bakand.data.database.MercedesBenzDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesNiaDatabase(
        @ApplicationContext context: Context,
    ): MercedesBenzDatabase = Room.databaseBuilder(
        context,
        MercedesBenzDatabase::class.java,
        "mercedes-benz-database",
    ).build()
}
