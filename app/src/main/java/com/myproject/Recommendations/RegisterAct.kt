package com.myproject.Recommendations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton

class RegisterAct : AppCompatActivity() {
    lateinit var btnAlReg : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnAlReg=findViewById(R.id.btnAlReg)

        btnAlReg.setOnClickListener {
            val intent = Intent (this@RegisterAct, LoginPage::class.java)
            startActivity(intent)
        }
    }
}