package shekarno.investing

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val paper1 = MyDataClass ("Apple", 100, true)
    val paper2 = MyDataClass ("Microsoft", 55, false)
    val paper3 = MyDataClass ("Facebook", 70, true)


    val collection = listOf(paper1,paper2,paper3)
    @Test
    fun addition_isCorrect() {
    print(collection.sort())
    }

    fun List<MyDataClass>.sort(): List<MyDataClass> {
        return collection.sortedWith(compareBy(MyDataClass::name, MyDataClass::price))
    }

}