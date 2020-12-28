package shekarno.investing.model.portfolio

import moxy.MvpPresenter
import shekarno.investing.Equity

class PortfolioPresenter : MvpPresenter<PortfolioView>() {

    private var equities = listOf<Equity>(
        Equity("Apple", "2", "US0378331005"),
        Equity("Tesla", "1", "US0378331005"),
        Equity("Facebook", "5", "US0378331005"),
        Equity("Microsoft", "4", "US0378331005"),
        Equity("Twitter", "7", "US0378331005"),
        Equity("Ford", "0", "US0378331005"),
        Equity("Fosfrd", "0", "US0378331005"),
        Equity("Fasvord", "2", "US0378331005"),
        Equity("Forczxcd", "5", "US0378331005"),
        Equity("Foasdard", "3", "US0378331005"),
        Equity("Fohgrd", "1", "US0378331005"),
        Equity("Forhrfdghd", "1", "US0378331005"),
        Equity("Foaewrd", "2", "US0378331005"),
        Equity("Foxzcrd", "7", "US0378331005"),
        Equity("Google", "2", "US0378331005")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEquities(equities)
    }

    fun onEquityClick(equity: Equity) {
        viewState.openDetails(equity)
    }
}