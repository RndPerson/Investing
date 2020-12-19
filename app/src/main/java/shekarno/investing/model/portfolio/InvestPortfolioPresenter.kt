package shekarno.investing.model.portfolio

import moxy.MvpPresenter
import shekarno.investing.Equity

class InvestPortfolioPresenter : MvpPresenter<InvestPortfolioView>() {

    private var equities = listOf<Equity>(
        Equity("Apple", "2"),
        Equity("Tesla", "1"),
        Equity("Facebook", "5"),
        Equity("Microsoft", "4"),
        Equity("Twitter", "7"),
        Equity("Ford", "0"),
        Equity("Google", "2")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEquities(equities)
        /* куда добавить фильтр? equities = equities.filter {equity.quantity != "0"}
            пытаюсь его засунуть сюда, добавив во входные параметры equity: Equity
            компилятор ругается на override
            фильтр нужен для того, чтобы акция с количеством 0 не отображалась в портфеле
            */
    }

    fun onEquityClick(equity: Equity) {
        viewState.openInvestMarket(equity)
    }
}