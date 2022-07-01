package com.myproject.Recommendations

import ApiRelated.RetrofitClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

//            val email = editUser.text.toString()
//            val password = editPass.text.toString().toInt()

            val res = RetrofitClient.instance.getQuotes().body()?.count.toString()
            if (res != null) {
                Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext, "No output", Toast.LENGTH_LONG).show()
            }

//            RetrofitClient.instance.login(email, password)
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
////                        if(response.body()?.message == "success"){
////                            val intent = Intent(applicationContext, MainActivity::class.java)
////                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
////
////                            startActivity(intent)
////                        }
////                        else{
////                            Toast.makeText(applicationContext, "hello",Toast.LENGTH_LONG).show()
////                        }
//                        val res = response.body().toString()
//                        Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
//                    }
//
//                })

//            if((enterUser==validUser) && (enterPass==validPass)){
//                val intent = Intent (this@LoginPage,MainActivity::class.java)
//                startActivity(intent)
//            }
//            else{
//                Toast.makeText(this@LoginPage,"Wrong Credentials",Toast.LENGTH_SHORT).show()
//            }
        }
        btnNewReg.setOnClickListener {
            val intent = Intent (this@LoginPage, RegisterAct::class.java)
            startActivity(intent)
        }
    }
}