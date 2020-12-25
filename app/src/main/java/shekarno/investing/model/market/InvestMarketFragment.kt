package shekarno.investing.model.market

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_invest_market.*
import kotlinx.android.synthetic.main.fragment_invest_portfolio.*
import kotlinx.android.synthetic.main.invest_portfolio_item.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.data.PortfolioDAOImpl
import shekarno.investing.model.search.SearchListFragment

class InvestMarketFragment : MvpAppCompatFragment(R.layout.fragment_invest_market),
    InvestMarketView {

    companion object {

        private const val EQUITY = "EQUITY"

        fun newInstance(equity: Equity) =
            InvestMarketFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EQUITY, equity)
                }
            }
    }

    private val presenter: InvestMarketPresenter by moxyPresenter {
        InvestMarketPresenter(
            equity = arguments?.getParcelable(EQUITY)!!,
            portfolioDao = PortfolioDAOImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        investMarketFavorite.setOnClickListener {
            presenter.onBuyClicked()
        }
    }

    override fun setEquity(equity: Equity) {
        tvName.text = equity.name
        tvQuantity.text = equity.quantity
    }

    override fun setIsInPortfolio(inPortfolio: Boolean) {
        investMarketFavorite.setImageResource(
            if (inPortfolio) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_border_24
        )
    }


}
