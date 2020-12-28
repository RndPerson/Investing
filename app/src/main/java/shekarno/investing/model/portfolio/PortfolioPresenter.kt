package shekarno.investing.model.portfolio

import moxy.MvpPresenter
import shekarno.investing.Equity

class PortfolioPresenter : MvpPresenter<PortfolioView>() {

    private var equities = listOf<Equity>(
        Equity("Apple", "2"),
        Equity("Tesla", "1"),
        Equity("Facebook", "5"),
        Equity("Microsoft", "4"),
        Equity("Twitter", "7"),
        Equity("Ford", "0"),
        Equity("Fosfrd", "0"),
        Equity("Fasvord", "2"),
        Equity("Forczxcd", "5"),
        Equity("Foasdard", "3"),
        Equity("Fohgrd", "1"),
        Equity("Forhrfdghd", "1"),
        Equity("Foaewrd", "2"),
        Equity("Foxzcrd", "7"),
        Equity("Google", "2")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEquities(equities.filter { it.quantity != "0" })
    }

    fun onEquityClick(equity: Equity) {
        viewState.openMarket(equity)
    }


}