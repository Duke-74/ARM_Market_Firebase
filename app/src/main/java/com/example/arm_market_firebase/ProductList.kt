package com.example.arm_market_firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arm_market_firebase.databinding.ActivityProductListBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ProductList : AppCompatActivity() {

    private val TAG = "MyApp"
    //private val adapter = ProductAdapter()
    lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "Переход на layout ProductList произошёл")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val backBtn = findViewById<Button>(R.id.productListBack)
        val db = Firebase.firestore
        val productStatus = intent.getStringExtra("period").toString()
        val name = intent.getStringExtra("prodType").toString()
        val recyclerView: RecyclerView = findViewById(R.id.productListRV)

        Log.i(TAG, "AAaaaaaaaaaaaaaaaaaaa")

        Log.i(TAG, "productStatus = $productStatus and name = $name")

        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

        //init()
        recyclerView.layoutManager = LinearLayoutManager(this)

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

//    private fun init(){
//        binding.apply {
//            Log.i(TAG, "DDdddddddddddddddddd")
//            productListRV.layoutManager = LinearLayoutManager(this@ProductList)
//            productListRV.adapter = adapter
//        }
//    }

}