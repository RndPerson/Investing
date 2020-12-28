package shekarno.investing.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

val newsApi : NewsApi = Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .client(OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-API-KEY", "8b87cc44eab34d9a9b6d18f7a528cecd").build()
                chain.proceed(request)
    }.build())
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()
    .create()