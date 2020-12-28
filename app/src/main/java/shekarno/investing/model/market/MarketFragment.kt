package shekarno.investing.model.market

import android.content.Context
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_market.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.data.FavouriteDAOImpl
import shekarno.investing.model.search.SearchListFragment

class MarketFragment : MvpAppCompatFragment(R.layout.fragment_market),
    MarketView {

    companion object {

        private const val EQUITY = "EQUITY"

        fun newInstance(equity: Equity) =
            MarketFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EQUITY, equity)
                }
            }
    }

    private val presenter: MarketPresenter by moxyPresenter {
        MarketPresenter(
            equity = arguments?.getParcelable(EQUITY)!!,
            favouriteDao = FavouriteDAOImpl(
                requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFavourite.setOnClickListener {
            presenter.onFavouriteClicked()
        }
        btnBuy.setOnClickListener {
            val plusQuantityToString = etSetQuantity.text.toString()
            val quantityToString = tvQuantity.text.toString()
            var count: Int = Integer.parseInt(quantityToString)
            val change: Int = Integer.parseInt(plusQuantityToString)
            count = count + change
            tvQuantity.text = count.toString()
        }
        btnSell.setOnClickListener {
            val minusQuantityToString = etSetQuantity.text.toString()
            val quantityToString = tvQuantity.text.toString()
            var count: Int = Integer.parseInt(quantityToString)
            val change: Int = Integer.parseInt(minusQuantityToString)
            count = count - change
            tvQuantity.text = count.toString()
        }
    }

    override fun setEquity(equity: Equity) {
        tvName.text = equity.name
        tvQuantity.text = equity.quantity
    }

    override fun setIsInFavourite(inFavourite: Boolean) {
        isFavourite.setImageResource(
            if (inFavourite) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_border_24
        )
    }
}
