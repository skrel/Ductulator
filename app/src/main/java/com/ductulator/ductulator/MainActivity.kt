package com.ductulator.ductulator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.sqrt
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {

            /* equiv round duct */

            val a: Double = W.text.toString().toDouble()
            val b: Double = H.text.toString().toDouble()
            val de: Double = (1.3 * Math.pow(a * b,0.625) / Math.pow(a + b,0.25))
            val deround: Double = de.toBigDecimal().setScale(0, RoundingMode.UP).toDouble()

            textView17.text = deround.toString() + " inch Ø"


            /* velocity */
            val cfm: Double = CFM.text.toString().toDouble()
            val v: Double = ((144 * cfm) / (a * b))
            val vround: Double = v.toBigDecimal().setScale(0, RoundingMode.UP).toDouble()

            textView7.text = vround.toString()


            /* friction loss */

            val dh: Double = ((0.10913 * Math.pow(cfm,1.9)) / (Math.pow(deround,5.02)))
            val dhround: Double = dh.toBigDecimal().setScale(5, RoundingMode.UP).toDouble()

            textView10.text = dhround.toString()


            /* equivalent rect size */

            val anew1: Double = a - 2
            val bnew1: Double = ((144 * cfm) / (anew1 * vround))
            val bnewround1: Double = bnew1.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()

            textView18.text = anew1.toString() + " X " + bnewround1.toString()


            val anew2: Double = a - 4
            val bnew2: Double = ((144 * cfm) / (anew2 * vround))
            val bnewround2: Double = bnew2.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()

            textView21.text = anew2.toString() + " X " + bnewround2.toString()




        }

    }
}
