package shekarno.investing.domain

import shekarno.investing.data.entity.Article
import kotlinx.coroutines.withContext
import shekarno.investing.News
import shekarno.investing.di.NewsApi

class GetMainNewsUseCase(private val newsApi: NewsApi) {
/*
    suspend operator fun invoke(): List<News> {
        return newsApi.getMainNews(country = "us").run {
            articles?.mapNotNull { news ->
                News(
                    title = article?.title ?: return@mapNotNull null,
                    description = article?.description ?: return@mapNotNull null,
                    image = article?.urlToImage ?: return@mapNotNull null,
                    url = article?.url ?: return@mapNotNull null,
                    date = article?.publishedAt ?: return@mapNotNull null
                )
            } ?: emptyList()
        }
    }
*/
}