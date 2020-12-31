package com.example.main_interface

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register.*

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val dbhelper = Database(this,"Personal.db",2)
        button3.setOnClickListener{
            val db = dbhelper.writableDatabase
            val account = editText3.text.toString()
            val password = editText4.text.toString()
            val users = ContentValues().apply {
                put("account",account)
                put("password",password)
            }
            db.insert("user",null,users)
            Toast.makeText(this,"注册成功！", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,login_register::class.java)
            startActivity(intent)
            finish()
        }
    }
}