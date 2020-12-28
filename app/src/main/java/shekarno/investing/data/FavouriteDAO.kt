package shekarno.investing.data

import shekarno.investing.Equity

interface FavouriteDAO {

    /**
     * добавление [equity] в портфель
     **/
    fun add(equity: Equity)

    /**
     * удаление акции из портфеля
     **/
    fun delete(equity: Equity)

    /**
     * @return акции в портфеле
     * может быть пустым
     */
    fun getAll(): List<Equity>

    /**
     * @return true если акция в портфолио, иначе false
     */
    fun isInFavourite(equity: Equity): Boolean
}

