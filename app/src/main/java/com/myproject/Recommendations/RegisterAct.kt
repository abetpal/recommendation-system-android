package com.myproject.Recommendations

import ApiRelated.RetrofitClient
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterAct : AppCompatActivity() {

    lateinit var btnAlReg : Button
    lateinit var nextbutton : Button
    lateinit var cancelbutton : Button
    lateinit var etfirstname : TextInputEditText
    lateinit var etlastname : TextInputEditText
    lateinit var etemail : TextInputEditText
    lateinit var etphone : TextInputEditText
    lateinit var etPass : TextInputEditText
    lateinit var etconPass : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnAlReg = findViewById(R.id.btnAlReg)
        etfirstname = findViewById(R.id.etfirstname)
        etlastname = findViewById(R.id.etlastname)
        etemail = findViewById(R.id.etemail)
        etphone = findViewById(R.id.etphone)
        etPass = findViewById(R.id.etPass)
        etconPass = findViewById(R.id.etconPass)
        nextbutton = findViewById(R.id.nextbutton)
        cancelbutton = findViewById(R.id.cancelbutton)

        btnAlReg.setOnClickListener {
            val intent = Intent (this@RegisterAct, LoginPage::class.java)
            startActivity(intent)
        }
        nextbutton.setOnClickListener{
            val name = etfirstname.text.toString()
            val last = etlastname.text.toString()
            val email = etemail.text.toString()
            val ph = etphone.text.toString()
            val password = etPass.text.toString()
            val conpass = etconPass.text.toString()

            if(password != conpass){
                etconPass.error = "It should be same as the Password"
                etconPass.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.createUser(name, email, password)
                .enqueue(object: Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        val res = response.body().toString()
                        Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
                    }

                })
        }
    }
}