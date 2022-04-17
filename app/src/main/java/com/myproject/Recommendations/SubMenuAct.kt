package com.myproject.Recommendations

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SubMenuAct : AppCompatActivity() {

    lateinit var recyclerMainPage: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter : RecAdptr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMainPage = findViewById(R.id.recyclerMainPage)
        layoutManager = LinearLayoutManager(this)
        recyclerMainPage.layoutManager = layoutManager
        recyclerAdapter = RecAdptr(this as Context)
        recyclerMainPage.adapter=recyclerAdapter
    }
}