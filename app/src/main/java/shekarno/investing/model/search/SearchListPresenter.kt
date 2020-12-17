package shekarno.investing.model.search

import android.provider.ContactsContract
import kotlinx.android.synthetic.main.fragment_search_list.*
import moxy.MvpPresenter
import shekarno.investing.SearchParam
import java.lang.Exception
import java.util.*
import kotlin.math.cos

class SearchListPresenter : MvpPresenter<SearchListView>() {

    var selectedCurrency = CURRENCY.ANY

    fun setCurrency(selectedCurrency: CURRENCY) {
        this.selectedCurrency = selectedCurrency
    }

    fun validate(costFrom: String, costTo: String, yearFrom: String, yearTo: String) {
        when {
            !costIsCorrect(costFrom) -> viewState.showCostFromError()
            !costIsCorrect(costTo) -> viewState.showCostToError()
            !yearIsCorrect(yearFrom) -> viewState.showYearFromError()
            !yearIsCorrect(yearTo) -> viewState.showYearToError()
            else -> saveData(costFrom, costTo, yearFrom, yearTo)
        }
    }

    private fun saveData(costFrom: String, costTo: String, yearFrom: String, yearTo: String) {

        val searchParam = SearchParam(costFrom, costTo, yearFrom, yearTo)
        viewState.showSaveData()
    }

    private fun costIsCorrect(costText: String): Boolean {
        if (costText.isEmpty()) return false

        return try {
            val cost = costText.toInt()
            cost in 0..10000
        } catch (e: Exception) {
            false
        }
    }

    private fun yearIsCorrect(yearText: String): Boolean {
        if (yearText.isEmpty()) return false

        return try {
            val year = yearText.toInt()
            year in 1970..2020
        } catch (e: Exception) {
            false
        }
    }

}