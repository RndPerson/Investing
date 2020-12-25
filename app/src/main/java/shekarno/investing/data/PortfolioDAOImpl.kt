package shekarno.investing.data

import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import shekarno.investing.Equity

class  PortfolioDAOImpl(
    private val sharedPreferences: SharedPreferences
) : PortfolioDAO {

    private var equities: List<Equity>
    get() = sharedPreferences.getString(PORTFOLIO_DAO_KEY, null)?.let {
        try {
            Json.decodeFromString<List<Equity>>(it)
        } catch (t: Throwable) {
            emptyList<Equity>()
        }
    } ?: emptyList()
    set(value) {
        sharedPreferences.edit().putString(
            PORTFOLIO_DAO_KEY,
            Json.encodeToString(value)
            ).apply()
    }

    override fun add(equity: Equity) {
        equities = equities + equity
    }

    override fun delete(equity: Equity) {
        equities = equities.filter { it != equity }
    }

    override fun getAll(): List<Equity> = equities

    override fun isInPortfolio(equity: Equity): Boolean = equities.contains(equity)

    companion object {

        private  const val PORTFOLIO_DAO_KEY = "PORTFOLIO_DAO_KEY"
    }

}