package shekarno.investing.model.portfolio

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import shekarno.investing.Equity

interface PortfolioView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setEquities(equities: List<Equity>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openMarket(equity: Equity)

}