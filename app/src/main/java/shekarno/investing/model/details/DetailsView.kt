package shekarno.investing.model.details

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import shekarno.investing.Equity

interface DetailsView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setEquity(equity: Equity)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setIsInFavourite(inFavourite: Boolean)

}