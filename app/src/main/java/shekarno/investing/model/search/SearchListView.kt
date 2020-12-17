package shekarno.investing.model.search

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

@AddToEnd
interface SearchListView : MvpView {

    fun showCostFromError()
    fun showCostToError()
    fun showYearFromError()
    fun showYearToError()
    fun showSaveData()
}