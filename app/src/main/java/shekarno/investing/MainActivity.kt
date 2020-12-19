package shekarno.investing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import shekarno.investing.model.portfolio.InvestPortfolioFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container,
                InvestPortfolioFragment()
            )
            .commit()
        }
    }