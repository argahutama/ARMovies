package com.project.armovie.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.armovie.R
import com.project.armovie.checkout.adapter.CheckoutAdapter
import com.project.armovie.checkout.model.Checkout
import com.project.armovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class CheckoutActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()
    private var total:Int = 0

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Checkout>


        for (a in dataList.indices){
            total += dataList[a].price!!.toInt()
        }

        dataList.add(
            Checkout(
                "Total Amount",
                total.toString()
            )
        )

        btn_purchase_now.setOnClickListener {
            val intent = Intent(this@CheckoutActivity,
                CheckoutSuccessActivity::class.java)
            startActivity(intent)
        }

        btn_cancel.setOnClickListener {
            finish()
        }

        rc_checkout.layoutManager = LinearLayoutManager(this)
        rc_checkout.adapter = CheckoutAdapter(dataList) {
        }

        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        tv_balance.setText(formatRupiah.format(preferences.getValues("balance")!!.toDouble()))
    }
}
