package shekarno.investing.model.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.portfolio_item.*
import shekarno.investing.Equity
import shekarno.investing.R

class PortfolioAdapter(private val onEquityClick: (Equity) -> Unit) :
    ListAdapter<Equity, PortfolioAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Equity>() {

        override fun areItemsTheSame(oldItem: Equity, newItem: Equity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Equity, newItem: Equity): Boolean {
            return oldItem == newItem
        }

    })
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.portfolio_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.equityName.text = item.name
        holder.equityQuantity.text = item.quantity
        holder.containerView.setOnClickListener {
            onEquityClick(item)
        }
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer
}
