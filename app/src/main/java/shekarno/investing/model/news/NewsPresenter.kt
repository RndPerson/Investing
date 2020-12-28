package shekarno.investing.model.news

import moxy.MvpPresenter
import shekarno.investing.News


class NewsPresenter : MvpPresenter<NewsView>() {

    private var news = listOf<News>(
        News("Title1", "Description1", "image1", "url1", "date1"),
        News("Title2", "Description2", "image2", "url2", "date2"),
        News("Title3", "Description3", "image3", "url3", "date3"),
        News("Title4", "Description4", "image4", "url4", "date4")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setNews(news)
    }

    fun onNewsClick(news: News) {
    }

}