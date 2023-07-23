package hossein.bakand.data.di

import android.content.Context
import android.telecom.Call
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hossein.bakand.core.common.BuildConfig
import hossein.bakand.data.api.MercedesBenzNetworkDataSource
import hossein.bakand.data.api.MercedesBenzNiaNetworkApi
import hossein.bakand.data.api.RetrofitMercedesBenzNetwork
import hossein.bakand.data.api.fake.FakeAssetManager
import hossein.bakand.data.api.interceptors.ApiKeyInterceptor
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val MercedesBenzBaseUrl =
    "https://api.mercedes-benz.com/configurator/v1/"//BuildConfig.BACKEND_URL

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
//        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            if (BuildConfig.DEBUG) {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        }

    @Provides
    @Singleton
    fun provideOkHttp(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @ExperimentalSerializationApi
    fun provideSerializableFactory(json: Json): Converter.Factory {
        return json.asConverterFactory("application/json".toMediaType())
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): MercedesBenzNiaNetworkApi {
        return Retrofit.Builder()
            .baseUrl(MercedesBenzBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(MercedesBenzNiaNetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMercedesBenzNetworkDataSource(
        mercedesBenzNiaNetworkApi: MercedesBenzNiaNetworkApi
    ): MercedesBenzNetworkDataSource {
        return RetrofitMercedesBenzNetwork(mercedesBenzNiaNetworkApi)
    }

    @Provides
    @Singleton
    fun providesFakeAssetManager(
        @ApplicationContext context: Context,
    ): FakeAssetManager = FakeAssetManager(context.assets::open)
}
