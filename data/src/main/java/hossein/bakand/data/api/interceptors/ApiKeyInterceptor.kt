package hossein.bakand.data.api.interceptors

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class ApiKeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter("apikey", "aa2eecd6-3b56-4f1b-9c9e-5feb327b8170")
            .build()

        val request= chain.request().newBuilder().url(newUrl).build()

        return chain.proceed(request)
    }
}
