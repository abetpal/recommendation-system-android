package com.myproject.Recommendations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecAdptr(val context : Context) : RecyclerView.Adapter<RecAdptr.SubMenuViewHolder>(){

    val  phoneList = arrayListOf(
        "Redmi 1", "Redmi 2", "Redmi 3", "Redmi 4", "Redmi 5", "Redmi 6", "Redmi 7", "Redmi 8", "Redmi 9", "Redmi 10"
    )
    val cam = arrayListOf(
        "2MP", "5MP", "8MP", "13MP", "16MP", "20MP", "25MP", "32MP", "48MP", "50MP"
    )
    val bat = arrayListOf(
        "2000mAh", "2200mAh", "2500mAh", "2800mAh", "3000mAh", "3200mAh", "3500mAh", "4000mAh", "4500mAh", "5000mAh"
    )
    val proc = arrayListOf(
        "SD 1000", "SD 2000", "SD3000", "SD4000", "SD5000", "SD6000", "SD7000", "SD8000", "SD9000", "SD10000"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row1,parent,false)
        return SubMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubMenuViewHolder, position: Int) {
        val text = phoneList[position]
        val text1 = cam[position]
        val text2 = bat[position]
        val text3 = proc[position]
        holder.textView.text = text
        holder.textView1.text = text1
        holder.textView2.text = text2
        holder.textView3.text = text3
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    class SubMenuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.txtTitle)
        val textView1 : TextView = view.findViewById(R.id.txtDetail1)
        val textView2 : TextView = view.findViewById(R.id.txtDetail2)
        val textView3 : TextView = view.findViewById(R.id.txtDetail3)
    }

}