package shekarno.investing.model.portfolio

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_portfolio.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.model.details.DetailsFragment

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        equitiesAdapter = null
    }

    override fun setEquities(equities: List<Equity>) {
        equitiesAdapter?.submitList(equities)
    }

    override fun openDetails(equity: Equity) {
        requireFragmentManager().beginTransaction()
            .replace(
                R.id.container,
                DetailsFragment.newInstance(equity)
            )
            .addToBackStack("DetailsFragment")
            .commit()
    }
}

