package shekarno.investing.data

import shekarno.investing.Equity

interface FavouriteDAO {

    /**
     * добавление [equity] в избранное
     **/
    fun add(equity: Equity)

    /**
     * удаление акции из избранного
     **/
    fun delete(equity: Equity)

    /**
     * @return акции в избранном
     * может быть пустым
     */
    fun getAll(): List<Equity>

    /**
     * @return true если акция в избранном, иначе false
     */
    fun isInFavourite(equity: Equity): Boolean
}

