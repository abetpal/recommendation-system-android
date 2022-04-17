package com.myproject.Recommendations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class LoginPage : AppCompatActivity() {
    lateinit var btnNewReg: MaterialButton
    lateinit var editUser : TextInputEditText
    lateinit var editPass : TextInputEditText
    lateinit var btnLogin : MaterialButton
    val validUser = "Admin"
    val validPass = "Admin@123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page2)

        editUser = findViewById(R.id.username_edit_text)
        editPass = findViewById(R.id.password_edit_text)
        btnLogin = findViewById(R.id.login_button)
        btnNewReg = findViewById(R.id.btnNewReg)

        btnLogin.setOnClickListener {

            val enterUser = editUser.text.toString()
            val enterPass = editPass.text.toString()

            if((enterUser==validUser) && (enterPass==validPass)){
                val intent = Intent (this@LoginPage,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@LoginPage,"Wrong Credentials",Toast.LENGTH_SHORT).show()
            }
        }
        btnNewReg.setOnClickListener {
            val intent = Intent (this@LoginPage, RegisterAct::class.java)
            startActivity(intent)
        }
    }
}