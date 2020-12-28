package shekarno.investing.model.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.News
import shekarno.investing.R
import shekarno.investing.model.details.DetailsFragment
import shekarno.investing.model.news.NewsAdapter

class NewsFragment : MvpAppCompatFragment(R.layout.fragment_news),
    NewsView {

    private val presenter: NewsPresenter by moxyPresenter {
        NewsPresenter()
    }

    private var newsAdapter: NewsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(newsList) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = NewsAdapter(onNewsClick = { equity ->
                presenter.onNewsClick(equity)
            }).also {
                newsAdapter = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        newsAdapter = null
    }

    override fun setNews(news: List<News>) {
        newsAdapter?.submitList(news)
    }

    override fun openNews(news: News) {
    }
}
