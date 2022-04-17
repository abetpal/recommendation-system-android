package com.myproject.Recommendations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdaptor(val context: Context, val menuList : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdaptor.MenuPageViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_row,parent,false)
         return MenuPageViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: MenuPageViewHolder, position: Int) {
        val text = menuList[position]
        holder.textView.text = text
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class MenuPageViewHolder(view:View, listener: onItemClickListener): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.txtRecRow)

        init {
            view.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}