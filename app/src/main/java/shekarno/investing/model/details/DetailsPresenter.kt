package shekarno.investing.model.details

import moxy.MvpPresenter
import shekarno.investing.Equity
import shekarno.investing.data.FavouriteDAO

class  DetailsPresenter(
    private val equity: Equity,
    private val favouriteDao: FavouriteDAO
) : MvpPresenter<DetailsView>() {

    private var isInFavourite: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setEquity(equity)
        isInFavourite = favouriteDao.isInFavourite(equity)
        viewState.setIsInFavourite(isInFavourite)
    }

    fun onFavouriteClicked() {
        if (isInFavourite) {
            favouriteDao.delete(equity)
        } else {
            favouriteDao.add(equity)
        }
        isInFavourite = !isInFavourite
        viewState.setIsInFavourite(isInFavourite)
    }

}