package shekarno.investing.model.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_search_list.*
import shekarno.investing.R

enum class CURRENCY { RUBLE, DOLLAR, EURO, ANY }

class SearchListFragment : Fragment(R.layout.fragment_search_list), SearchListView {

    private val presenter = SearchListPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initListeners()
    }

    private fun initListeners() {

        rgCurrency.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->

            val selectedCurrency = when (checkedId) {
                R.id.rbRuble -> CURRENCY.RUBLE
                R.id.rbDollar -> CURRENCY.DOLLAR
                R.id.rbEuro -> CURRENCY.EURO
                else -> CURRENCY.ANY
            }

            presenter.setCurrency(selectedCurrency)
        }

        btnSearch.setOnClickListener {
            presenter.validateAndSaveData(
                etCostFrom.text.toString(),
                etCostTo.text.toString(),
                etYearFrom.text.toString(),
                etYearTo.text.toString()
            )
        }
    }

    override fun showSaveData() {
        Toast.makeText(requireContext(), "Данные сохранены", Toast.LENGTH_LONG).show()
    }

    override  fun showCostFromError() {
        showError("Стоимость от")
    }

    override fun showCostToError() {
        showError("Стоимость до")
    }

    override fun showYearFromError() {
        showError("Год от")
    }

    override fun showYearToError() {
        showError("Год до")
    }

    private fun showError (name: String) {
        Toast.makeText(requireContext(), "Ошибка в поле $name", Toast.LENGTH_LONG).show()
    }
}