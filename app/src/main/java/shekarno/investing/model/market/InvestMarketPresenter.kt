package shekarno.investing.model.market

import moxy.MvpPresenter
import shekarno.investing.Equity
import shekarno.investing.data.PortfolioDAO

class InvestMarketPresenter(
    private val equity: Equity,
    private val portfolioDao: PortfolioDAO
) : MvpPresenter<InvestMarketView>() {

    private var isInPortfolio: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEquity(equity)
        isInPortfolio = portfolioDao.isInPortfolio(equity)
        viewState.setIsInPortfolio(isInPortfolio)
    }

    fun onBuyClicked() {
        if (isInPortfolio) {
            portfolioDao.delete(equity)
        } else {
            portfolioDao.add(equity)
        }
        isInPortfolio = !isInPortfolio
        viewState.setIsInPortfolio(isInPortfolio)
    }

}