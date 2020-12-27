package shekarno.investing.model.portfolio

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_portfolio.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.model.market.MarketFragment
import shekarno.investing.R
import shekarno.investing.model.search.SearchListFragment

class PortfolioFragment : MvpAppCompatFragment(R.layout.fragment_portfolio),
    PortfolioView {

    private val presenter: PortfolioPresenter by moxyPresenter {
        PortfolioPresenter()
    }

    private var equitiesAdapter: PortfolioAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvPortfolio) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = PortfolioAdapter(onEquityClick = { equity ->
                presenter.onEquityClick(equity)
            }).also {
                equitiesAdapter = it
            }
        }

        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(
                    R.id.container,
                    MarketFragment()
                )
                .addToBackStack("SearchListFragment")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        equitiesAdapter = null
    }

    override fun setEquities(equities: List<Equity>) {
        equitiesAdapter?.submitList(equities)
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

