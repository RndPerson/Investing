package shekarno.investing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_invest_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_invest_details.tvQuantity as tvQuantity1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okay= intent.extras?.getString("PaperBack")

        tvQuantity.text = okay

        btnGoToDetails.setOnClickListener {
            val paper = Paper("Apple", "3")

            val intent = Intent(this, InvestDetailsActivity::class.java)
            intent.putExtra("Paper", paper)
            startActivity(intent)
        }
    }
}