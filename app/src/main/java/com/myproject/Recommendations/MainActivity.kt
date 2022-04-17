package com.myproject.Recommendations

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerMainPage: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val menuList = arrayListOf(
        "Phones",
        "Laptops",
        "SmartWatches"
    )

    lateinit var recyclerAdapter : RecyclerAdaptor
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMainPage=findViewById(R.id.recyclerMainPage)
        layoutManager = LinearLayoutManager(this)

        recyclerMainPage.layoutManager = layoutManager

        recyclerAdapter = RecyclerAdaptor(this as Context,menuList)
        recyclerMainPage.adapter= recyclerAdapter
        recyclerAdapter.setOnItemClickListener(object : RecyclerAdaptor.onItemClickListener{
            override fun onItemClick(position: Int) {
                if(position==0){
                    val intent = Intent(this@MainActivity, SubMenuAct::class.java)
                    startActivity(intent)
                }
                else{
                    val dum = menuList[position]
                    Toast.makeText(this@MainActivity,"You clicked on $dum",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}

