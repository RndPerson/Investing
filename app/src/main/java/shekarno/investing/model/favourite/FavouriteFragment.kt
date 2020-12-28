package shekarno.investing.model.favourite

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favourite.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.data.FavouriteDAOImpl
import shekarno.investing.model.market.MarketFragment
import shekarno.investing.model.portfolio.PortfolioAdapter

class FavouriteFragment : MvpAppCompatFragment(R.layout.fragment_favourite), FavouriteView {

    companion object {
        fun newInstance() = FavouriteFragment()
    }

    private val presenter: FavouritePresenter by moxyPresenter {
        FavouritePresenter(
            favouriteDAO = FavouriteDAOImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
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