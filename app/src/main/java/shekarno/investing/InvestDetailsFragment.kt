package shekarno.investing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_invest_portfolio.*
import shekarno.investing.model.search.SearchListFragment

class InvestDetailsFragment : Fragment(R.layout.fragment_invest_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

}