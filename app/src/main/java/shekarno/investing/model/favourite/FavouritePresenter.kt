package shekarno.investing.model.favourite

import moxy.MvpPresenter
import shekarno.investing.Equity
import shekarno.investing.data.FavouriteDAO


class FavouritePresenter(
    private val favouriteDAO: FavouriteDAO
) : MvpPresenter<FavouriteView>() {

    private var equities: List<Equity> = emptyList()

    override fun attachView(view: FavouriteView?) {
        super.attachView(view)
        equities = favouriteDAO.getAll()
        viewState.setEquities(equities)
    }

    fun onEquityClick(equity: Equity) {
        viewState.openMarket(equity)
    }
}

