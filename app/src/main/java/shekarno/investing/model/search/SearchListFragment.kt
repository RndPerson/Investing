package shekarno.investing.model.search

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_search_list.*
import kotlinx.android.synthetic.main.fragment_search_list.favouriteList
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.data.FavouriteDAOImpl
import shekarno.investing.model.favourite.FavouriteFragment
import shekarno.investing.model.favourite.FavouritePresenter
import shekarno.investing.model.market.MarketFragment
import shekarno.investing.model.portfolio.PortfolioAdapter
import shekarno.investing.model.portfolio.PortfolioPresenter


class SearchListFragment : MvpAppCompatFragment(R.layout.fragment_search_list), SearchListView {

    companion object {
        fun newInstance() = SearchListFragment()
    }

    private val presenter: SearchListPresenter by moxyPresenter {
        SearchListPresenter()
    }

    private var favouritesAdapter: PortfolioAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(favouriteList) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = PortfolioAdapter(onEquityClick = { equity ->
                presenter.onEquityClick(equity)
            }).also {
                favouritesAdapter = it
            }
        }
    }

    override fun setEquities(equities: List<Equity>) {
        favouritesAdapter?.submitList(equities)
    }

    override fun openMarket(equity: Equity) {
        requireFragmentManager().beginTransaction()
            .replace(
                R.id.container,
                MarketFragment.newInstance(equity)
            )
            .addToBackStack("MarketFragment")
            .commit()
    }

}