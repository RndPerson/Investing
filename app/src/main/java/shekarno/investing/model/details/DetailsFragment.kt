package shekarno.investing.model.details

import android.content.Context
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_details.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import shekarno.investing.Equity
import shekarno.investing.R
import shekarno.investing.data.FavouriteDAOImpl

class DetailsFragment : MvpAppCompatFragment(R.layout.fragment_details),
    DetailsView {

    companion object {

        private const val EQUITY = "EQUITY"

        fun newInstance(equity: Equity) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EQUITY, equity)
                }
            }
    }

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter(
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
    }

    override fun setEquity(equity: Equity) {
        tvName.text = equity.name
        tvPrice.text = equity.price
    }

    override fun setIsInFavourite(inFavourite: Boolean) {
        isFavourite.setImageResource(
            if (inFavourite) R.drawable.ic_baseline_star_24 else R.drawable.ic_baseline_star_border_24
        )
    }

}