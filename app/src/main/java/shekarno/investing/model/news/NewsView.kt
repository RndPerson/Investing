package shekarno.investing.model.news

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import shekarno.investing.News

interface NewsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setNews(news: List<News>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openNews(news: News)

}