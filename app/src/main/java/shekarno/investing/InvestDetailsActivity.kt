package shekarno.investing

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_invest_details.*
import kotlinx.android.synthetic.main.activity_invest_details.tvQuantity
import kotlinx.android.synthetic.main.activity_main.*

class InvestDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invest_details)

        val paper = intent.extras?.getSerializable("Paper") as Paper

        tvName.text = paper.name
        tvQuantity.text = paper.quantity

        btnGoToBack.setOnClickListener {
            val okay = tvQuantity.text
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("PaperBack", okay)
            startActivity(intent)
        }
    }

    fun buyClick(view: View?) {
        val cnt = findViewById<View>(R.id.tvQuantity) as TextView
        val zz = cnt.text
        var pz = Integer.valueOf(zz.toString())
        pz++
        cnt.text = Integer.toString(pz)
        }

    fun sellClick(view: View?) {
        val cnt = findViewById<View>(R.id.tvQuantity) as TextView
        val zz = cnt.text
        var pz = Integer.valueOf(zz.toString())
        pz--
        cnt.text = Integer.toString(pz)
    }


    }