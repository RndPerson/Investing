package shekarno.investing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_invest_portfolio.*
import shekarno.investing.model.search.SearchListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InvestPortfolioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InvestPortfolioFragment : Fragment(R.layout.fragment_invest_portfolio) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnGoToMarket.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, InvestMarketFragment())
                .addToBackStack("InvestMarketFragment")
                .commit()
        }

            btnGoToSearch.setOnClickListener {
                requireFragmentManager().beginTransaction()
                    .replace(R.id.container,
                        SearchListFragment()
                    )
                    .addToBackStack("SearchListFragment")
                    .commit()
            }
        }

        companion object {


            fun newInstance(param1: String, param2: String) =
                InvestPortfolioFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
        }
    }