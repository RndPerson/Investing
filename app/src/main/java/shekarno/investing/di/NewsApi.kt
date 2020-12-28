package shekarno.investing.di

import retrofit2.http.GET
import retrofit2.http.Query
import shekarno.investing.data.entity.MainNewsResponse

interface  NewsApi {

    @GET("v2/top-headlines")
    fun getMainNews(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business"
    ): MainNewsResponse
}