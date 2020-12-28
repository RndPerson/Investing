package shekarno.investing.model.search

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEnd
import shekarno.investing.Equity


interface SearchListView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setEquities(equities: List<Equity>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openMarket(equity: Equity)

}