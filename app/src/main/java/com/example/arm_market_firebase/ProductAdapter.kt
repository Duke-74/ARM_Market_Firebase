package com.example.arm_market_firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.arm_market_firebase.databinding.ActivityProdElementBinding

class ProductAdapter(private val list: List<HashMap<String, String>>):
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.productTypeElement)
        val date: TextView = itemView.findViewById(R.id.productDateElement)
        val time: TextView = itemView.findViewById(R.id.productTimeElement)
        val amount: TextView = itemView.findViewById(R.id.productAmountElement)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_prod_element, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = list[position]["name"]
        holder.date.text = list[position]["date"]
        holder.time.text = list[position]["time"]
        holder.amount.text = list[position]["amount"]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}