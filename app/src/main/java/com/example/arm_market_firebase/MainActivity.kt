package com.example.arm_market_firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainBtn = findViewById<Button>(R.id.futureDeliveries)
        val productTypeSpinnerList = resources.getStringArray(R.array.productType)
        val radioGroup = findViewById<RadioGroup>(R.id.radioBtnGr)
        val TAG = "MyApp"
        var product = "Nothing"
        var period = "Never"

        //Spinner
        val spinner = findViewById<Spinner>(R.id.spinnerMainActivity)
        val arrayAdapter = ArrayAdapter<Spinner>(this, R.layout.activity_main)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                product = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, productTypeSpinnerList
            )
            spinner.adapter = adapter
            spinner.setSelection(0)
        }

        //RadioGroup
        radioGroup.setOnCheckedChangeListener{radioGroup, checkedID ->
            if(checkedID == R.id.radioButton1)
                period = "past"
            else
                period = "future"
        }

        mainBtn.setOnClickListener {

            val intent = Intent(this, ProductList::class.java).apply {
                putExtra("period", "$period")
                putExtra("prodType", "$product")
            }
            Log.i(TAG, "Intent на layout MainActivity сформирован")
            startActivity(intent)
        }
    }

    fun checkPeriod(radioGr: RadioGroup): String {
        val selectedOption: Int = radioGr!!.checkedRadioButtonId
        var period = ""

        if (selectedOption.equals("radioButton1"))
            period = "past"
        else
            period = "future"
        return period
    }

}