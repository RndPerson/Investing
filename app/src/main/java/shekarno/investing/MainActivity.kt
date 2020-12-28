package shekarno.investing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import shekarno.investing.model.favourite.FavouriteFragment
import shekarno.investing.model.news.NewsFragment
import shekarno.investing.model.portfolio.PortfolioFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val portfolioFragment = PortfolioFragment()
        val favouriteFragment =
            FavouriteFragment()
        val newsFragment = NewsFragment()

        makeCurrentFragment(portfolioFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.portfolio -> makeCurrentFragment(portfolioFragment)
                R.id.news -> makeCurrentFragment(newsFragment)
                R.id.favourite -> makeCurrentFragment(favouriteFragment)

            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }
}