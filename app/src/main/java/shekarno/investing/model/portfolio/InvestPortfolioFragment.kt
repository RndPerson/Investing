package shekarno.investing.model.portfolio

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_invest_portfolio.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.model.market.InvestMarketFragment
import shekarno.investing.R
import shekarno.investing.model.search.SearchListFragment

class InvestPortfolioFragment : MvpAppCompatFragment(R.layout.fragment_invest_portfolio),
    InvestPortfolioView {

    private val presenter: InvestPortfolioPresenter by moxyPresenter {
        InvestPortfolioPresenter()
    }

    private var equitiesAdapter: InvestPortfolioAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvInvestPortfolio) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = InvestPortfolioAdapter(onEquityClick = { equity ->
                presenter.onEquityClick(equity)
            }).also {
                equitiesAdapter = it
            }
        }

        btnGoToSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(
                    R.id.container,
                    SearchListFragment()
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

    override fun openInvestMarket(equity: Equity) {
        requireFragmentManager().beginTransaction()
            .replace(
                R.id.container,
                InvestMarketFragment.newInstance(equity)
            )
            .addToBackStack("InvestMarketFragment")
            .commit()
    }
}

