package shekarno.investing.data

import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import shekarno.investing.Equity

class  FavouriteDAOImpl(
    private val sharedPreferences: SharedPreferences
) : FavouriteDAO {

    private var equities: List<Equity>
    get() = sharedPreferences.getString(FAVOURITE_DAO_KEY, null)?.let {
        try {
            Json.decodeFromString<List<Equity>>(it)
        } catch (t: Throwable) {
            emptyList<Equity>()
        }
    } ?: emptyList()
    set(value) {
        sharedPreferences.edit().putString(
            FAVOURITE_DAO_KEY,
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

    override fun isInFavourite(equity: Equity): Boolean = equities.contains(equity)

    companion object {

        private  const val FAVOURITE_DAO_KEY = "FAVOURITE_DAO_KEY"
    }

}