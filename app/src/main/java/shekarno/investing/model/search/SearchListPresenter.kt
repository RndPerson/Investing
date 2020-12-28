package shekarno.investing.model.search

import moxy.MvpPresenter
import shekarno.investing.Equity
import shekarno.investing.data.FavouriteDAO
import shekarno.investing.model.favourite.FavouriteView

class SearchListPresenter : MvpPresenter<SearchListView>() {

    fun onEquityClick(equity: Equity) {
        viewState.openMarket(equity)
    }

}